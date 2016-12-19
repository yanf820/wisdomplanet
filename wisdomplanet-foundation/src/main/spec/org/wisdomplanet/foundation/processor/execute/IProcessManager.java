/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IProcessManager.java
 * @Prject: wisdomplanet-foundation
 * @Package: org.wisdomplanet.foundation.processor.execute
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-05
 * @version: V1.0  
 */
package org.wisdomplanet.foundation.processor.execute;

import java.util.List;

import org.wisdomplanet.foundation.processor.config.ProcessorGraph;


/**
 * @ClassName: IProcessManager
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public interface IProcessManager {
	
    public void setExecutor(IProcessExecutor executor);

    public IProcessExecutor getExecutor();

    public void executeProcesses(String processId, String ... args) throws Exception;

    public void registerProcess(ProcessorGraph processorGraph);

    public List<ProcessorGraph> getProcesses();
    
}