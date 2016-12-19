/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: EventObject.java
 * @Prject: wisdom
 * @Package: com.wisdom.core.model
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-11-28
 * @version: V1.0  
 */
package org.wisdomplanet.model;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @ClassName: EventObject
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-11-28
 */
public class EventObject {

	private String id;
	
	private String type;
	
	private Map<String, String> fields;
	
	private Map<String, String> properties;
	
	private Timestamp timeStamp;
	
	public EventObject(){
		this.fields = new HashMap<String,String>();
	}
	
	public void setFields(String key,String value){
		fields.put(key, value);
	}

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the fields
	 */
	public Map<String, String> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}

	/**
	 * @return the properties
	 */
	public Map<String, String> getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	
	/**
	 * @return the timeStamp
	 */
	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false);
    }
	
	
}
