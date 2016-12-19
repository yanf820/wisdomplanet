/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IValidattorManager.java
 * @Prject: wisdom-service
 * @Package: com.wisdom.service.validation
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-05
 * @version: V1.0  
 */
package org.wisdomplanet.service.validator;

/**
 * @ClassName: IValidattorManager
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public interface IValidattorManager {

	void registerValidator(IValidator validator);
	
	IValidator findValidatorById(String validatorId);
	
	String[] getValidatorIds();
	
	IValidator[] getValidators();
}
