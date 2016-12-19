/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IValidatorRequest.java
 * @Prject: wisdom-service
 * @Package: com.wisdom.service.validation
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-11-29
 * @version: V1.0  
 */
package org.wisdomplanet.service.validator;

import java.util.Map;

import org.wisdomplanet.model.EventObject;


/**
 * @ClassName: IValidatorRequest
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-11-29
 */
public interface IValidatorContext {
	
	String getValidationType();
	
	Map<String, String> getValidateParams();
	
	EventObject getEventObject();
	
	String getFocusFieldName();
}
