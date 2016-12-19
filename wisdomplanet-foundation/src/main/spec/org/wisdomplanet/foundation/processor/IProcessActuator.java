/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IProcessActuator.java
 * @Prject: wisdomplanet-foundation
 * @Package: org.wisdomplanet.foundation.processor
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-05
 * @version: V1.0  
 */
package org.wisdomplanet.foundation.processor;

import org.wisdomplanet.foundation.processor.config.ProcessorGraph;

/**
 * @ClassName: IProcessActuator
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public interface IProcessActuator {

    public void initialize(ProcessorGraph graph, String ... args);

    public void launch() throws Exception;

    public void shutdown() throws Exception;

    public boolean isLaunched();

}
