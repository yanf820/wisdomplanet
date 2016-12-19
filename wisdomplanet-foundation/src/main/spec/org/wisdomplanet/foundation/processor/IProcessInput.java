/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IProcessInput.java
 * @Prject: wisdomplanet-foundation
 * @Package: org.wisdomplanet.foundation.processor
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-05
 * @version: V1.0  
 */
package org.wisdomplanet.foundation.processor;

import java.io.Serializable;

/**
 * @ClassName: IProcessInput
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public interface IProcessInput extends Serializable {

    public Object getInputObject();

    public boolean hasInputObject();

}
