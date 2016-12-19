/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: Dimension.java
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
 * @ClassName: Dimension
 * @Description: 数据维度
 * @author: A.Z
 * @date: 2016-12-08
 */
public class DatumDimension {
	
	/**
	 * 维度列
	 */
	private String[] dimensions;
	/**
	 * 不需要使用的维度列
	 */
	private String[] dimensionExclusions;
	/**
	 * 空间性的维度
	 */
//	private SpatialDimension[] spatialDimensions;
	/**
	 * @return the dimensions
	 */
	public String[] getDimensions() {
		return dimensions;
	}
	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimensions(String[] dimensions) {
		this.dimensions = dimensions;
	}
	/**
	 * @return the dimensionExclusions
	 */
	public String[] getDimensionExclusions() {
		return dimensionExclusions;
	}
	/**
	 * @param dimensionExclusions the dimensionExclusions to set
	 */
	public void setDimensionExclusions(String[] dimensionExclusions) {
		this.dimensionExclusions = dimensionExclusions;
	}
	
	@Override
	public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false);
    }
}
