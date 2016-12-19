package org.wisdomplanet.worker.transform;

import java.util.concurrent.atomic.AtomicLong;

import org.wisdomplanet.foundation.processor.BaseProcessor;
import org.wisdomplanet.foundation.processor.IProcessInput;
import org.wisdomplanet.foundation.processor.IProcessOutput;
import org.wisdomplanet.model.EventDatum;
import org.wisdomplanet.model.EventObject;
import org.wisdomplanet.service.transform.ITransform;
import org.wisdomplanet.service.transform.TransformInput;
import org.wisdomplanet.service.transform.TransformOutput;
import org.wisdomplanet.service.transform.config.TransformContext;


public class TransformProcessor extends BaseProcessor {


	private static AtomicLong index = new AtomicLong(0);
    
	private ITransform transform;
	
	public TransformProcessor(ITransform transform,TransformContext context) throws Exception{
		this.transform = transform;
		transform.init(context);
	}

    public void processDatum(EventDatum datum, IProcessInput input, IProcessOutput output) throws Exception {

    		TransformInput transformInput = new TransformInput(datum);
    		TransformOutput transformOutput = new TransformOutput();
    		transform.transform(transformInput, transformOutput);
        	System.out.println("TransformProcessor process task:" + datum + " " + Thread.currentThread().getId() + "  " + index.get());
        	for (EventObject eo : transformOutput.getEventObjects()) {
        		output.getCollector().collect(eo);
			}

    }

}
