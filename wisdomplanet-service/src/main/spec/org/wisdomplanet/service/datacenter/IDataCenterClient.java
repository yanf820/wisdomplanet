/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IDataCenterClient.java
 * @Prject: wisdomplanet-service
 * @Package: org.wisdomplanet.service.datacenter
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-13
 * @version: V1.0  
 */
package org.wisdomplanet.service.datacenter;

/**
 * @ClassName: IDataCenterClient
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-13
 */
public interface IDataCenterClient {
	
	public void action(IDataCenterRequest request, IDataCenterResponse response) throws Exception;

}
