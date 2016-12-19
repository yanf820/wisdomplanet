/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: DataCenterServletContext.java
 * @Prject: wisdomplanet-service
 * @Package: org.wisdomplanet.service.datacenter.config
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-11
 * @version: V1.0  
 */
package org.wisdomplanet.service.datacenter.config;

import org.wisdomplanet.service.datacenter.storage.IDataCenterStorage;

/**
 * @ClassName: DataCenterServletContext
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-11
 */
public class DataCenterServletContext {

	private IDataCenterStorage dataCenterStorage;

	/**
	 * @return the dataCenterStorage
	 */
	public IDataCenterStorage getDataCenterStorage() {
		return dataCenterStorage;
	}

	/**
	 * @param dataCenterStorage the dataCenterStorage to set
	 */
	public void setDataCenterStorage(IDataCenterStorage dataCenterStorage) {
		this.dataCenterStorage = dataCenterStorage;
	}
	
	

}
