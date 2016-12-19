package org.wisdomplanet.foundation.processor.standalone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.wisdomplanet.foundation.component.IComponentProvider;
import org.wisdomplanet.foundation.processor.ICollector;
import org.wisdomplanet.foundation.processor.IProcessor;
import org.wisdomplanet.foundation.processor.ProcessActivateContext;
import org.wisdomplanet.foundation.processor.config.ProcessorLinker;
import org.wisdomplanet.foundation.processor.config.ProcessorNode;


/**
 */
public class StandaloneProcessorAgent implements ICollector {

    private ProcessorNode processorNode;
    private List<ProcessorLinker> toLinkers;
    private ExecutorService executorService;
    private IProcessor processor;
    private boolean asProducer;
    private StandaloneProcessActuator standaloneProcessActuator;
    private IComponentProvider componentProvider;
    private ICollector globalCollector;

    private LinkedBlockingQueue<ProcessTask> inputTasks;
    private AtomicBoolean currentOrWillStopped;
    private int localParallelism;

    private List<StandaloneProcessorThread> processorThreads;

    public StandaloneProcessorAgent(ProcessorNode processorNode, List<ProcessorLinker> toLinkers, boolean asProducer, StandaloneProcessActuator standaloneProcessActuator, ICollector globalCollector, IComponentProvider componentProvider) {
        this.processorNode = processorNode;
        this.toLinkers = toLinkers;
        this.asProducer = asProducer;
        this.standaloneProcessActuator = standaloneProcessActuator;
        this.componentProvider = componentProvider;
        this.globalCollector = globalCollector;

        this.inputTasks = new LinkedBlockingQueue<ProcessTask>();
        this.currentOrWillStopped = new AtomicBoolean(true);
        this.processorThreads = new ArrayList<StandaloneProcessorThread>();

        this.localParallelism = this.processorNode.getParallelism()<=0?1:this.processorNode.getParallelism();
    }

    public void init() throws Exception {
        this.executorService = Executors.newFixedThreadPool(this.localParallelism);
        this.processor = (IProcessor) this.componentProvider.getComponent(this.processorNode.getComponentId());
    }

    public long appendTask(ProcessTask task) {
        if(task != null) {
            try {
                this.inputTasks.put(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.inputTasks.size();
    }

    public void start() throws Exception {
        this.currentOrWillStopped.set(false);

        ProcessActivateContext activateContext = new ProcessActivateContext();
        this.processor.activate(activateContext);

        this.processorThreads.clear();
        for(int i=0; i<this.localParallelism; i++) {
            StandaloneProcessorThread processorThread = new StandaloneProcessorThread(this);
            this.processorThreads.add(processorThread);
            this.executorService.execute(processorThread);
        }

    }

    public void shutdown() throws Exception {
        this.currentOrWillStopped.set(true);
        this.executorService.shutdownNow();
        this.processor.deactivate();
    }

    @Override
    public void collect(Object object) {
        if(object!=null){
            if(this.toLinkers!=null)for(ProcessorLinker link : this.toLinkers){
                ProcessTask taskObject = new ProcessTask();
                taskObject.setFromNodeId(this.processorNode.getId());
                taskObject.setToNodeId(link.getToNodeId());
                taskObject.setTaskObject(object);
                this.globalCollector.collect(taskObject);
            }
        }
    }

    public ProcessTask pollTask() {
        try {
            return this.inputTasks.poll(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return null;
        }
    }

    public IProcessor getProcessor() {
        return processor;
    }

    public boolean isCurrentOrWillStopped(){
        return this.currentOrWillStopped.get();
    }

    public boolean isAsProducer() {
        return asProducer;
    }

    public boolean isActuatorBusy() {
        return this.standaloneProcessActuator.isInBusy();
    }
}
