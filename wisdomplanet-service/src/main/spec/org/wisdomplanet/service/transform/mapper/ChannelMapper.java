/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: ChannelMapper.java
 * @Prject: wisdom-service
 * @Package: com.wisdom.service.transformation.mapping
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-02
 * @version: V1.0  
 */
package org.wisdomplanet.service.transform.mapper;

import java.util.Map;

/**
 * @ClassName: ChannelMapper
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-02
 */
public class ChannelMapper {
	
	public String map(String fieldName, String express, Map<String,String> variable){
		String var = variable.get(fieldName);
		return var;
	}

}
