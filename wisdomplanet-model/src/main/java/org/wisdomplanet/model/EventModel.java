/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: EventModel.java
 * @Prject: wisdom
 * @Package: com.wisdom.core.model
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-11-28
 * @version: V1.0  
 */
package org.wisdomplanet.model;

import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @ClassName: EventModel
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-11-28
 */
public class EventModel {
	
	private String id;
	
	private String name;
	
	private String title;
	
	private String desc;
	
	private String type;
	
	private List<Field> fields;
	
	private List<Validation> validations;
	
	private List<Channel> channels;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
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
	public List<Field> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	/**
	 * @return the validations
	 */
	public List<Validation> getValidations() {
		return validations;
	}

	/**
	 * @param validations the validations to set
	 */
	public void setValidations(List<Validation> validations) {
		this.validations = validations;
	}

	/**
	 * @return the channels
	 */
	public List<Channel> getChannels() {
		return channels;
	}

	/**
	 * @param channels the channels to set
	 */
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	
	@Override
	public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false);
    }
	
}
