/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IValidator.java
 * @Prject: wisdom
 * @Package: com.wisdom.core.model
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-11-28
 * @version: V1.0  
 */
package org.wisdomplanet.service.validator;

/**
 * @ClassName: IValidator
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-11-28
 */
public interface IValidator {
	
	String getId();
	
	String validate(IValidatorContext context) throws Exception;
}
