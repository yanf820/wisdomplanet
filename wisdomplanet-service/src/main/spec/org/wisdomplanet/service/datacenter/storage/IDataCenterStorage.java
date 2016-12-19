/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IDatacenterStorage.java
 * @Prject: wisdomplanet-service
 * @Package: org.wisdomplanet.service.datacenter.storage
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-07
 * @version: V1.0  
 */
package org.wisdomplanet.service.datacenter.storage;

import org.wisdomplanet.service.command.DataCenterCommand;

/**
 * @ClassName: IDatacenterStorage
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-07
 */
public interface IDataCenterStorage {

	public void execute(DataCenterCommand command, String... arg) throws Exception;
	
}
