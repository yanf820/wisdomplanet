/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IDataCenterClient.java
 * @Prject: wisdomplanet-service
 * @Package: org.wisdomplanet.service.datacenter
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-05
 * @version: V1.0  
 */
package org.wisdomplanet.service.datacenter;

import org.wisdomplanet.service.datacenter.config.DataCenterServletContext;

/**
 * @ClassName: IDataCenterClient
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public interface IDataCenterServlet {
	
	void init(DataCenterServletContext context) throws Exception;
	
	void service(IDataCenterRequest request,IDataCenterResponse response) throws Exception;
	
}
