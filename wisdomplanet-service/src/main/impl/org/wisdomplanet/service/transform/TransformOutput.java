/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: TransformerOutput.java
 * @Prject: wisdom-service
 * @Package: com.wisdom.service.transformaition
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-02
 * @version: V1.0  
 */
package org.wisdomplanet.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.wisdomplanet.model.EventObject;
import org.wisdomplanet.service.provider.IEventObjectProvider;
import org.wisdomplanet.service.transform.ITransformOutput;


/**
 * @ClassName: TransformerOutput
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-02
 */
public class TransformOutput implements ITransformOutput{
	
	
	private List<EventObject> eventObjects;
	
	public TransformOutput(){
		this(new ArrayList<EventObject>());
	}
	
	public TransformOutput(List<EventObject> eventObjects){
		this.eventObjects = eventObjects;
	}
	
	/**
	 * @return the eventObjects
	 */
	public List<EventObject> getEventObjects() {
		return eventObjects;
	}

	/* (non Javadoc)
	 * @Title: output
	 * @Description: TODO
	 * @param provider
	 * @throws Exception
	 * @see com.wisdom.service.transform.ITransformOutput#output(com.wisdom.service.provider.IEventObjectProvider)
	 */
	@Override
	public void output(IEventObjectProvider provider) throws Exception {
		EventObject eo = new EventObject();
		provider.provide(eo);
		this.eventObjects.add(eo);
	}
	
}
