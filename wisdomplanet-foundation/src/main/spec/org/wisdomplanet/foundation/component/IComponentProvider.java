/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IComponentProvider.java
 * @Prject: wisdomplanet-foundation
 * @Package: org.wisdomplanet.foundation
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-05
 * @version: V1.0  
 */
package org.wisdomplanet.foundation.component;

import java.io.Serializable;

/**
 * @ClassName: IComponentProvider
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public interface IComponentProvider extends Serializable {

    public Object getComponent(String componentId);

}
