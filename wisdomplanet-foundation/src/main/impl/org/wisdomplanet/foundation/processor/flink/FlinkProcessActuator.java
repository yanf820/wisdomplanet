package org.wisdomplanet.foundation.processor.flink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.wisdomplanet.foundation.component.IComponentProvider;
import org.wisdomplanet.foundation.processor.IProcessActuator;
import org.wisdomplanet.foundation.processor.config.ProcessorGraph;
import org.wisdomplanet.foundation.processor.config.ProcessorLinker;
import org.wisdomplanet.foundation.processor.config.ProcessorNode;

/**
 */
public class FlinkProcessActuator implements IProcessActuator {

    private ProcessorGraph processorGraph;
    private String[] processorArgs;
    private boolean launched;
    private Map<String, FlinkProcessorChainNode> chainNodeMap;
    private IComponentProvider componentProvider;

    public FlinkProcessActuator(IComponentProvider componentProvider) {
        this.componentProvider = componentProvider;
        this.chainNodeMap = new HashMap<String, FlinkProcessorChainNode>();
    }

    @Override
    public void initialize(ProcessorGraph graph, String... args) {
        this.processorGraph = graph;
        this.processorArgs = args;
        this.launched = false;
    }

    @Override
    public void launch() throws Exception {
        this.launched = false;
        if(this.processorGraph == null) return;

        List<ProcessorNode> producerNodes = this.processorGraph.getProducerNodes();
        if(producerNodes==null || producerNodes.size()==0) return;

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        for(ProcessorNode pn : this.processorGraph.getNodes()) {
            if(this.processorGraph.isProducerNode(pn.getId())){
                FlinkProcessProducer producer = new FlinkProcessProducer(pn, this.componentProvider);
                FlinkProcessorChainNode chainNode = new FlinkProcessorChainNode(producer);
                this.chainNodeMap.put(pn.getId(), chainNode);
            }else{
                FlinkProcessConsumer consumer = new FlinkProcessConsumer(pn, this.componentProvider);
                FlinkProcessorChainNode chainNode = new FlinkProcessorChainNode(consumer);
                this.chainNodeMap.put(pn.getId(), chainNode);
            }
        }

        for(String chainNodeId : this.chainNodeMap.keySet()){
            this.setupChainObjectNode(chainNodeId, env);
        }

        System.out.println(">>>>>>>>>> " + env.getExecutionPlan());

        env.execute("Execute graph plan : GraphId[" + this.processorGraph.getGraphId() + "]");
    }

    private DataStream setupChainObjectNode(String nodeId, StreamExecutionEnvironment env) {
        FlinkProcessorChainNode chainNode = this.chainNodeMap.get(nodeId);
        if(chainNode == null) return null;

        if(chainNode.getChainObject()!=null){
            return (DataStream) chainNode.getChainObject();
        }

        List<ProcessorLinker> linkers = this.processorGraph.findLinkersByNodeId(nodeId, false); //find upstreams
        if(linkers.size() == 0 && processorGraph.isProducerNode(nodeId)){
            DataStream dataStreamSource = env.addSource((FlinkProcessProducer)chainNode.getAgent()).returns(chainNode.getAgent().getOutputType()).name(nodeId).shuffle();
            chainNode.setChainObject(dataStreamSource);
            return dataStreamSource;
        }else if(linkers.size()>0 && !processorGraph.isProducerNode(nodeId)){
            List<DataStream> streams = new ArrayList<DataStream>();
            for (ProcessorLinker linker : linkers) {
                DataStream dataStream = this.setupChainObjectNode(linker.getFromNodeId(), env);
                if(dataStream!=null) {
                    streams.add(dataStream);
                }
            }
            if(streams.size() == 1){
                DataStream ds = streams.get(0).flatMap((FlinkProcessConsumer) chainNode.getAgent()).returns(chainNode.getAgent().getOutputType()).name(nodeId);
                chainNode.setChainObject(ds);
                return ds;
            }else if(streams.size()>1){
                DataStream ds = streams.get(0).union(streams.subList(1, streams.size()).toArray(new DataStream[streams.size() - 1])).flatMap((FlinkProcessConsumer) chainNode.getAgent()).returns(chainNode.getAgent().getOutputType()).name(nodeId);
                chainNode.setChainObject(ds);
                return ds;
            }else{
                return null;
            }

        }else{
            return null;
        }

    }

    @Override
    public void shutdown() throws Exception {

    }

    @Override
    public boolean isLaunched() {
        return this.launched;
    }

    public class FlinkProcessorChainNode{

        private IFlinkProcessorAgent agent;
        private Object chainObject;

        public FlinkProcessorChainNode(IFlinkProcessorAgent agent) {
            this.agent = agent;
        }

        public IFlinkProcessorAgent getAgent() {
            return agent;
        }

        public Object getChainObject() {
            return chainObject;
        }

        public void setChainObject(Object chainObject) {
            this.chainObject = chainObject;
        }
    }
}
