package org.wisdomplanet.foundation.processor.flink;

import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.wisdomplanet.foundation.component.IComponentProvider;
import org.wisdomplanet.foundation.processor.ICollector;
import org.wisdomplanet.foundation.processor.IProcessor;
import org.wisdomplanet.foundation.processor.ProcessActivateContext;
import org.wisdomplanet.foundation.processor.ProcessInput;
import org.wisdomplanet.foundation.processor.ProcessOutput;
import org.wisdomplanet.foundation.processor.config.ProcessorNode;

/**
 */
public class FlinkProcessConsumer extends RichFlatMapFunction implements IFlinkProcessorAgent {

    private boolean asProducer;
    private ProcessorNode processorNode;
    private IComponentProvider componentProvider;
    private IProcessor processor;
    private boolean willCancel;
    private Class outputType;

    public FlinkProcessConsumer(ProcessorNode processorNode, IComponentProvider componentProvider) {
        this.processorNode = processorNode;
        this.componentProvider = componentProvider;
        this.willCancel = false;
        this.asProducer = false;
    }

    @Override
    public void flatMap(Object input, final Collector collector) throws Exception {
        ICollector proxyCollector = new ICollector() {
            @Override
            public void collect(Object object) {
                collector.collect(object);
            }
        };

        ProcessInput processInput = new ProcessInput();
        processInput.setInputObject(input);
        ProcessOutput processOutput = new ProcessOutput();
        processOutput.setCollector(proxyCollector);

        try {
            this.processor.process(processInput, processOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        this.processor = (IProcessor) this.componentProvider.getComponent(this.processorNode.getComponentId());
        ProcessActivateContext activateContext = new ProcessActivateContext();
        this.processor.activate(activateContext);
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
}
