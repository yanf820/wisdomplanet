/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: ProcessorGraphUtil.java
 * @Prject: wisdomplanet-worker
 * @Package: org.wisdomplanet.worker
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-06
 * @version: V1.0  
 */
package org.wisdomplanet.worker;

import org.wisdomplanet.foundation.processor.config.ProcessorGraph;
import org.wisdomplanet.foundation.processor.config.ProcessorGraphBuilder;
import org.wisdomplanet.foundation.processor.config.ProcessorNodeBuilder;
import org.wisdomplanet.model.EventDatum;
import org.wisdomplanet.model.EventObject;

/**
 * @ClassName: ProcessorGraphUtil
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-06
 */
public class ProcessorGraphUtil {

	public static ProcessorGraph makeTransformGraph(){
		ProcessorGraph graph = ProcessorGraphBuilder.createWithId("transformegraph")
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
