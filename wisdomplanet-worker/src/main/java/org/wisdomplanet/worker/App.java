package org.wisdomplanet.worker;

import org.wisdomplanet.foundation.component.IComponentProvider;
import org.wisdomplanet.foundation.component.SpringApplicationContextUtils;
import org.wisdomplanet.foundation.component.SpringComponentProvider;
import org.wisdomplanet.foundation.processor.config.ProcessorGraph;
import org.wisdomplanet.foundation.processor.config.ProcessorGraphBuilder;
import org.wisdomplanet.foundation.processor.config.ProcessorNodeBuilder;
import org.wisdomplanet.foundation.processor.execute.DefaultProcessManager;
import org.wisdomplanet.foundation.processor.execute.IProcessManager;
import org.wisdomplanet.foundation.processor.flink.FlinkProcessExecutor;
import org.wisdomplanet.foundation.processor.standalone.StandaloneProcessExecutor;
import org.wisdomplanet.model.EventDatum;
import org.wisdomplanet.model.EventObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	String executeProcessId = null;
        String[] executeProcessArgs = null;

        if(args.length > 0) {
            executeProcessId = args[0];
        }
        if(args.length > 2) {
            executeProcessArgs = new String[args.length-1];
            System.arraycopy(args, 1,executeProcessArgs, 0, executeProcessArgs.length);
        }else{
            executeProcessArgs = new String[0];
        }
        
        String executorType = System.getProperty("mx.processor.executorType", "flink");
		
        SpringApplicationContextUtils.setContextId("wisdomplanet.xml");
	    IComponentProvider componentProvider = new SpringComponentProvider();
	    
	    StandaloneProcessExecutor standaloneProcessExecutor = new StandaloneProcessExecutor(componentProvider);
	    FlinkProcessExecutor flinkProcessExecutor = new FlinkProcessExecutor(componentProvider);
	    IProcessManager processManager = new DefaultProcessManager();
	    
	    if("flink".equals(executorType)){
	    	processManager.setExecutor(flinkProcessExecutor);
	    }else{
	    	processManager.setExecutor(standaloneProcessExecutor);
	    }
	    
	    //register graph
	    processManager.registerProcess(makeTransformGraph());
	    
	    //startup
        if(executeProcessId != null) {
            processManager.executeProcesses(executeProcessId, executeProcessArgs);
        }else{
            processManager.executeProcesses("transformgraph");
        }
    }
    
    private static ProcessorGraph makeTransformGraph(){
    		ProcessorGraph graph = ProcessorGraphBuilder.createWithId("transformgraph")
    	            .addNode(ProcessorNodeBuilder.createWithId("input")
    	                    .withComponentId("datumProducer")
    	                    .withParallelism(1)
    	                    .withOutputType(EventDatum.class)
    	            )
    	            .addNode(ProcessorNodeBuilder.createWithId("output")
    	                    .withComponentId("transformProcess")
    	                    .withParallelism(5)
    	                    .withOutputType(EventObject.class)
    	                    .from("input")
    	            )
    	            .addNode(ProcessorNodeBuilder.createWithId("writer")
    	                    .withComponentId("datumConsumer")
    	                    .withParallelism(5)
    	                    .from("output")
    	            )
    	            .build();
    		return graph;
    }
}
