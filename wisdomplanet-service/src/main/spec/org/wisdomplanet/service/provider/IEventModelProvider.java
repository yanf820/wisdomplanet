/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IEventModelProvider.java
 * @Prject: wisdomplanet-service
 * @Package: org.wisdomplanet.service.datacenter
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-06
 * @version: V1.0  
 */
package org.wisdomplanet.service.provider;

import org.wisdomplanet.model.EventModel;

/**
 * @ClassName: IEventModelProvider
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-06
 */
public interface IEventModelProvider {

	void provide(EventModel eventModel);
}
