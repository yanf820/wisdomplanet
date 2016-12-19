/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: MetricSpace.java
 * @Prject: wisdomplanet-model
 * @Package: org.wisdomplanet.model
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-08
 * @version: V1.0  
 */
package org.wisdomplanet.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @ClassName: MetricSpace
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-08
 */
public class DatumMetricSpace {
	
	/**
	 * 度量类型
	 */
	private String type;
	/**
	 * 度量名称
	 */
	private String name;
	/**
	 * 度量名字
	 */
	private String fieldName;
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
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	@Override
	public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false);
    }
	
}
