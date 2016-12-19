/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: Index.java
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
 * @ClassName: Index
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-08
 */
public class DatumIndex {
	
	private String type;
	private String indexDim;
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
	 * @return the indexDim
	 */
	public String getIndexDim() {
		return indexDim;
	}
	/**
	 * @param indexDim the indexDim to set
	 */
	public void setIndexDim(String indexDim) {
		this.indexDim = indexDim;
	}
	
	@Override
	public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false);
    }

}
