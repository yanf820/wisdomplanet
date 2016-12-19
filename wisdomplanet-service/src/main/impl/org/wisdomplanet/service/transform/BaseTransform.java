package org.wisdomplanet.service.transform;

import java.util.List;

import org.wisdomplanet.model.EventDatum;
import org.wisdomplanet.model.EventModel;
import org.wisdomplanet.service.transform.ITransform;
import org.wisdomplanet.service.transform.ITransformInput;
import org.wisdomplanet.service.transform.ITransformOutput;
import org.wisdomplanet.service.transform.config.TransformContext;


public abstract class BaseTransform implements ITransform{
	
	private TransformContext context;
	

	/* (non Javadoc)
	 * @Title: init
	 * @Description: TODO
	 * @throws Exception
	 * @see com.wisdom.service.transform.ITransform#init()
	 */
	@Override
	public void init(TransformContext context) throws Exception {
		System.out.println("Transform init");
		this.context = context;
	}

	/* (non Javadoc)
	 * @Title: transform
	 * @Description: TODO
	 * @param input
	 * @param output
	 * @throws Exception
	 * @see com.wisdom.service.transform.ITransform#transform(com.wisdom.service.transform.ITransformInput, com.wisdom.service.transform.ITransformOutput)
	 */
	@Override
	public void transform(ITransformInput input, ITransformOutput output) throws Exception {
		System.out.println("start transform");
		EventDatum ed = getEventDatum(input);
		List<EventModel> ems = getEventModel(ed.getTags());
		if (ems == null || ems.size() == 0) {
			System.out.println("EventModels is null");
			return;
		} 
		for (EventModel em : ems) {
			transformDatum(ed, em, output);
		}
	}
	
	/**
	 * @param eventDatum
	 * @param eventModel
	 * @param output
	 */
	protected abstract void transformDatum(EventDatum eventDatum, EventModel eventModel, ITransformOutput output) throws Exception; 

	protected abstract List<EventModel> getEventModel(String tags);
	
	protected EventDatum getEventDatum(ITransformInput input){
		return input.getEventDatum();
	}

	/**
	 * @return the context
	 */
	public TransformContext getContext() {
		return context;
	}
	
	
}
