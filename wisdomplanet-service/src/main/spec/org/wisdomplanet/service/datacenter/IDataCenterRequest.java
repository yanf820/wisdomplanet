/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IDatumCenterRequest.java
 * @Prject: wisdomplanet-service
 * @Package: org.wisdomplanet.service.datacenter
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-07
 * @version: V1.0  
 */
package org.wisdomplanet.service.datacenter;

import org.wisdomplanet.model.DatumFilter;
import org.wisdomplanet.model.EventObject;

/**
 * @ClassName: IDatumCenterRequest
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-07
 */
public interface IDataCenterRequest {
	
	public String getCommand();
	
	public EventObject getData();
	
	public DatumFilter getFilter();

}
