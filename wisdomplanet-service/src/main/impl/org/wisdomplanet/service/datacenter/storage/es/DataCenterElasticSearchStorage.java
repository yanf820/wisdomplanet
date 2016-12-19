/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: DataCenterStorage.java
 * @Prject: wisdomplanet-service
 * @Package: org.wisdomplanet.service.datacenter.storage
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-11
 * @version: V1.0  
 */
package org.wisdomplanet.service.datacenter.storage.es;

import org.wisdomplanet.service.command.DataCenterCommand;
import org.wisdomplanet.service.datacenter.storage.IDataCenterStorage;

/**
 * @ClassName: DataCenterStorage
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-11
 */
public class DataCenterElasticSearchStorage implements IDataCenterStorage {
	
	/* (non Javadoc)
	 * @Title: execute
	 * @Description: TODO
	 * @param command
	 * @param arg
	 * @throws Exception
	 * @see org.wisdomplanet.service.datacenter.storage.IDataCenterStorage#execute(org.wisdomplanet.service.datacenter.command.IDataCenterCommand, java.lang.String[])
	 */
	@Override
	public void execute(DataCenterCommand command, String... arg) throws Exception {
		System.out.println("execute es Command");
	}

}
