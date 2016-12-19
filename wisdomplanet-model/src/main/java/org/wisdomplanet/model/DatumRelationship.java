/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: Relationship.java
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
 * @ClassName: Relationship
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-08
 */
public class DatumRelationship {

	private String type;
	private String relationshipDatumId;
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
	 * @return the relationshipDatumId
	 */
	public String getRelationshipDatumId() {
		return relationshipDatumId;
	}
	/**
	 * @param relationshipDatumId the relationshipDatumId to set
	 */
	public void setRelationshipDatumId(String relationshipDatumId) {
		this.relationshipDatumId = relationshipDatumId;
	}
	
	@Override
	public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false);
    }
}
