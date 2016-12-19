/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: DataCenterCommand.java
 * @Prject: wisdomplanet-service
 * @Package: org.wisdomplanet.service.command
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-11
 * @version: V1.0  
 */
package org.wisdomplanet.service.command;

import org.wisdomplanet.model.StructureDatum;

/**
 * @ClassName: DataCenterCommand
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-11
 */
public class DataCenterCommand {

	
	private String commandId;
	
	private StructureDatum datumStructure;

	/**
	 * @return the commandId
	 */
	public String getCommandId() {
		return commandId;
	}

	/**
	 * @param commandId the commandId to set
	 */
	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	/**
	 * @return the datumStructure
	 */
	public StructureDatum getDatumStructure() {
		return datumStructure;
	}

	/**
	 * @param datumStructure the datumStructure to set
	 */
	public void setDatumStructure(StructureDatum datumStructure) {
		this.datumStructure = datumStructure;
	}
	
	
	
}
