/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: TimestampSepc.java
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
 * @ClassName: TimestampSepc
 * @Description: 时间戳规范
 * @author: A.Z
 * @date: 2016-12-08
 */
public class DatumTimestampSepc {

	private String column;
	private String format;
	/**
	 * @return the column
	 */
	public String getColumn() {
		return column;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(String column) {
		this.column = column;
	}
	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	
	@Override
	public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false);
    }
}
