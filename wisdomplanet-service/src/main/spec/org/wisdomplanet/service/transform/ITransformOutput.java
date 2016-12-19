package org.wisdomplanet.service.transform;

import org.wisdomplanet.service.provider.IEventObjectProvider;

public interface ITransformOutput {
	
	void output(IEventObjectProvider provider) throws Exception;
}



