/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: DataCenterMysqlStorage.java
 * @Prject: wisdomplanet-service
 * @Package: org.wisdomplanet.service.datacenter.storage.es
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-12
 * @version: V1.0  
 */
package org.wisdomplanet.service.datacenter.storage.mysql;

import java.io.File;
import java.io.FileWriter;

import org.wisdomplanet.service.command.DataCenterCommand;
import org.wisdomplanet.service.datacenter.storage.IDataCenterStorage;

/**
 * @ClassName: DataCenterMysqlStorage
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-12
 */
public class DataCenterMysqlStorage implements IDataCenterStorage{

	/* (non Javadoc)
	 * @Title: execute
	 * @Description: TODO
	 * @param command
	 * @param arg
	 * @throws Exception
	 * @see org.wisdomplanet.service.datacenter.storage.IDataCenterStorage#execute(org.wisdomplanet.service.command.DataCenterCommand, java.lang.String[])
	 */
	@Override
	public void execute(DataCenterCommand command, String... arg) throws Exception {

	}

}
