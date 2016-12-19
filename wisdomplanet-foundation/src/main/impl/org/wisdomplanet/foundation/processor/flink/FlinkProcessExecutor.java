package org.wisdomplanet.foundation.processor.flink;

import org.wisdomplanet.foundation.component.IComponentProvider;
import org.wisdomplanet.foundation.processor.config.ProcessorGraph;
import org.wisdomplanet.foundation.processor.execute.IProcessExecutor;

/**
 * Created by shixin on 2016/11/2.
 */
public class FlinkProcessExecutor implements IProcessExecutor {

    private IComponentProvider componentProvider;

    public FlinkProcessExecutor(IComponentProvider componentProvider) {
        this.componentProvider = componentProvider;
    }

    @Override
    public void execute(ProcessorGraph processorGraph, String... args) throws Exception {
        FlinkProcessActuator actuator = new FlinkProcessActuator(this.componentProvider);
        actuator.initialize(processorGraph, args);
        actuator.launch();
    }
}
