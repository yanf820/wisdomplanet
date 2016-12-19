/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: Channel.java
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
 * @ClassName: Channel
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-11-28
 */
public class Channel {

	private String id;
	
	private String title;
	
	private String desc;
	
	private String tags;
	
	private List<ChannelMapping> mappings;
	
	public Channel(String id,String title,String desc,String tags,List<ChannelMapping> mappings){
		this.id = id;
		this.title = title;
		this.tags = tags;
		this.mappings = mappings;
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
	 * @return the mappings
	 */
	public List<ChannelMapping> getMappings() {
		return mappings;
	}

	/**
	 * @param mappings the mappings to set
	 */
	public void setMappings(List<ChannelMapping> mappings) {
		this.mappings = mappings;
	}
	
	@Override
	public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false);
    }
}
