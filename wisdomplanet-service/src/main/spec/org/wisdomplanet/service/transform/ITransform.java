package org.wisdomplanet.service.transform;

import org.wisdomplanet.service.transform.config.TransformContext;

public interface ITransform {
	
	void init(TransformContext context) throws Exception;
	
	void transform(ITransformInput input, ITransformOutput output) throws Exception;
	
}
