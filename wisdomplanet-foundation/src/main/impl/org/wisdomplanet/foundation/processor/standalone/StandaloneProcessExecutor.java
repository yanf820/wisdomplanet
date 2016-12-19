package org.wisdomplanet.foundation.processor.standalone;

import org.wisdomplanet.foundation.component.IComponentProvider;
import org.wisdomplanet.foundation.processor.config.ProcessorGraph;
import org.wisdomplanet.foundation.processor.execute.IProcessExecutor;

/**
 */
public class StandaloneProcessExecutor implements IProcessExecutor {

    private IComponentProvider componentProvider;

    public StandaloneProcessExecutor(IComponentProvider componentProvider) {
        this.componentProvider = componentProvider;
    }

    @Override
    public void execute(ProcessorGraph processGraph, String... args) throws Exception {
        StandaloneProcessActuator actuator = new StandaloneProcessActuator(this.componentProvider);
        actuator.setMaxPending(100000);
        actuator.initialize(processGraph, args);
        actuator.launch();
    }
}
