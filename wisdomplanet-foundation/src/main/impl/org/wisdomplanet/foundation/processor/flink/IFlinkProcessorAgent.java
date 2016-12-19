package org.wisdomplanet.foundation.processor.flink;

import org.wisdomplanet.foundation.processor.config.ProcessorNode;

/**
 */
public interface IFlinkProcessorAgent {

    public boolean isAsProducer();

    public ProcessorNode getProcessorNode();

    public Class getOutputType();

}
