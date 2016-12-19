/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IProcessExecutor.java
 * @Prject: wisdomplanet-foundation
 * @Package: org.wisdomplanet.foundation.processor.execute
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-05
 * @version: V1.0  
 */
package org.wisdomplanet.foundation.processor.execute;

import org.wisdomplanet.foundation.processor.config.ProcessorGraph;

/**
 * @ClassName: IProcessExecutor
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public interface IProcessExecutor {

	public void execute(ProcessorGraph processorGraph, String ... args) throws Exception;
	
}
