/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: EventDatum.java
 * @Prject: wisdom
 * @Package: com.wisdom.core.model
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-11-28
 * @version: V1.0  
 */
package org.wisdomplanet.model;

import java.sql.Timestamp;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * @ClassName: EventDatum
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-11-28
 */
public class EventDatum {
	
	private String id;
	
	private String host;
	
	private String ip;
	
	private Timestamp time;
	
	private String tags;
	
	private Map<String, String> dataMap;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the time
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @return the dataMap
	 */
	public Map<String, String> getDataMap() {
		return dataMap;
	}

	/**
	 * @param dataMap the dataMap to set
	 */
	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}
	
	@Override
	public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false);
    }
	

}
