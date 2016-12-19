/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: ProcessorGraphBuilder.java
 * @Prject: wisdomplanet-foundation
 * @Package: org.wisdomplanet.foundation.processor.config
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-05
 * @version: V1.0  
 */
package org.wisdomplanet.foundation.processor.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ProcessorGraphBuilder
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public class ProcessorGraphBuilder {

    public static ProcessorGraphBuilder createWithId(String graphId) {
        ProcessorGraphBuilder gb = new ProcessorGraphBuilder(graphId);
        return gb;
    }

    private ProcessorGraph graph;
    private List<ProcessorNodeBuilder> nodeBuilders;

    public ProcessorGraphBuilder(String graphId) {
        this.graph = new ProcessorGraph();
        this.graph.setGraphId(graphId);
        this.nodeBuilders = new ArrayList<ProcessorNodeBuilder>();
    }

    public ProcessorGraphBuilder addNode(ProcessorNodeBuilder nodeBuilder) {
        this.nodeBuilders.add(nodeBuilder);
        return this;
    }

    public ProcessorGraph build() {
        ProcessorGraph g = new ProcessorGraph();

        List<ProcessorNode> nodes = new ArrayList<ProcessorNode>();
        List<ProcessorLinker> linkers = new ArrayList<ProcessorLinker>();
        for(ProcessorNodeBuilder nb : this.nodeBuilders) {
            ProcessorNode node = nb.getProcessorNode();
            List<ProcessorLinker> ls = nb.getProcessorLinkers();
            if(!nodes.contains(node)) nodes.add(node);
            for(ProcessorLinker pl : ls){
                if(!linkers.contains(pl)) linkers.add(pl);
            }
        }
        g.setGraphId(this.graph.getGraphId());
        g.setLinkers(linkers);
        g.setNodes(nodes);
        return g;
    }

    public static void main(String[] args) {
        ProcessorGraph graph = ProcessorGraphBuilder.createWithId("transformer")
                .addNode(ProcessorNodeBuilder.createWithId("input")
                        .withComponentId("comp-input")
                        .withParallelism(1)
                )
                .addNode(ProcessorNodeBuilder.createWithId("ouput")
                        .withComponentId("comp-output")
                        .withParallelism(1)
                        .from("input")
                ).build();

        System.out.println(">> " + graph);

    }

}
