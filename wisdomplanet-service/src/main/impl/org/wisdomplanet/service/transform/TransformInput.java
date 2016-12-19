/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: TransformerInput.java
 * @Prject: wisdom-service
 * @Package: com.wisdom.service.transformaition
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-02
 * @version: V1.0  
 */
package org.wisdomplanet.service.transform;

import org.wisdomplanet.model.EventDatum;
import org.wisdomplanet.service.transform.ITransformInput;



/**
 * @ClassName: TransformerInput
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-02
 */
public class TransformInput implements ITransformInput {
	
	
	private EventDatum eventDatum;
	
	public TransformInput(){
		
	}
	public TransformInput(EventDatum eventDatum){
		this.eventDatum = eventDatum;
	}

	/* (non-Javadoc)
	 * @see com.wisdom.service.transformation.ITransformerInput#getEventDatum()
	 */
	@Override
	public EventDatum getEventDatum() {
		return eventDatum;
	}

	/* (non-Javadoc)
	 * @see com.wisdom.service.transformation.ITransformerInput#hasEventDatum()
	 */
	@Override
	public boolean hasEventDatum() {
		return true;
	}

}
