package org.wisdomplanet.service.transform;

import org.wisdomplanet.model.EventDatum;

public interface ITransformInput {
	
	EventDatum getEventDatum();
	
	boolean hasEventDatum();
	
}
