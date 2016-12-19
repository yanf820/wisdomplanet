/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: DataCenterDatum.java
 * @Prject: wisdomplanet-model
 * @Package: org.wisdomplanet.model
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-08
 * @version: V1.0  
 */
package org.wisdomplanet.model;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @ClassName: DataCenterDatum
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-08
 */
public class StructureDatum {
	
	/**
	 * 数据唯一标识
	 */
	private String id;
	/**
	 * 事件时间戳
	 */
	private Timestamp eventTime;
	/**
	 * 事件时间对象
	 */
	private EventTime eventDisplayTime;
	/**
	 * 事件类型
	 */
	private EventType eventType;
	/**
	 * 事件地点
	 */
	private EventLocation eventLocation;
	/**
	 * 事件线索
	 */
	private List<EventClue> eventClue;
	/**
	 * 事件关系
	 */
	private List<EventRelatonship> relationship;
//	/**
//	 * 数据度量列
//	 */
//	private List<DatumMetricSpace> metricSpaces;
//	/**
//	 * 数据关系
//	 */
//	private List<DatumRelationship> relationship;
	
	@Override
	public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false);
    }
}
