/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: TransformationContext.java
 * @Prject: wisdom
 * @Package: com.wisdom.core.transformation
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-11-28
 * @version: V1.0  
 */
package org.wisdomplanet.service.transform.config;

import org.wisdomplanet.service.datacenter.DataCenterClientDemo;
import org.wisdomplanet.service.transform.mapper.ChannelMapper;

/**
 * @ClassName: TransformationContext
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-11-28
 */
public class TransformContext {
	
	private DataCenterClientDemo dataCenterClient;
	private ChannelMapper channelMapper;

	/**
	 * @return the dataCenterClient
	 */
	public DataCenterClientDemo getDataCenterClient() {
		return dataCenterClient;
	}

	/**
	 * @param dataCenterClient the dataCenterClient to set
	 */
	public void setDataCenterClient(DataCenterClientDemo dataCenterClient) {
		this.dataCenterClient = dataCenterClient;
	}

	/**
	 * @return the channelMapper
	 */
	public ChannelMapper getChannelMapper() {
		return channelMapper;
	}

	/**
	 * @param channelMapper the channelMapper to set
	 */
	public void setChannelMapper(ChannelMapper channelMapper) {
		this.channelMapper = channelMapper;
	}
	
	
	
}
