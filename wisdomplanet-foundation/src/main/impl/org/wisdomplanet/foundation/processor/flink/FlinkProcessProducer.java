package org.wisdomplanet.foundation.processor.flink;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.wisdomplanet.foundation.component.IComponentProvider;
import org.wisdomplanet.foundation.processor.IProcessor;
import org.wisdomplanet.foundation.processor.ProcessActivateContext;
import org.wisdomplanet.foundation.processor.ProcessInput;
import org.wisdomplanet.foundation.processor.ProcessOutput;
import org.wisdomplanet.foundation.processor.config.ProcessorNode;

/**
 */
public class FlinkProcessProducer extends RichSourceFunction implements IFlinkProcessorAgent {

    private final boolean asProducer;
    private ProcessorNode processorNode;
    private IComponentProvider componentProvider;
    private IProcessor processor;
    private boolean willCancel;
    private Class outputType;

    public FlinkProcessProducer(ProcessorNode processorNode, IComponentProvider componentProvider) {
        this.processorNode = processorNode;
        this.componentProvider = componentProvider;
        this.willCancel = false;
        this.asProducer = true;
    }

    @Override
    public void run(SourceContext sourceContext) throws Exception {
        SourceContextProxyCollector proxyCollector = new SourceContextProxyCollector(sourceContext);
        while(!this.willCancel){

            ProcessInput processInput = new ProcessInput();
            processInput.setInputObject(null);

            proxyCollector.reset();
            ProcessOutput processOutput = new ProcessOutput();
            processOutput.setCollector(proxyCollector);

            try {
                this.processor.process(processInput, processOutput);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(!proxyCollector.hasObjectsCollectted()){
                Thread.sleep(100);
            }

        }
    }

    @Override
    public void cancel() {
        this.willCancel = true;
    }

    @Override
    public boolean isAsProducer() {
        return this.asProducer;
    }

    @Override
    public ProcessorNode getProcessorNode() {
        return this.processorNode;
    }

    @Override
    public Class getOutputType() {
        return this.processorNode.getOutputType() == null ? Object.class : this.processorNode.getOutputType();
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        this.processor = (IProcessor) this.componentProvider.getComponent(this.processorNode.getComponentId());
        ProcessActivateContext activateContext = new ProcessActivateContext();
        this.processor.activate(activateContext);
    }
}
