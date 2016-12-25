package org.wisdomplanet.worker.simulation;

import org.wisdomplanet.foundation.processor.BaseProcessor;
import org.wisdomplanet.foundation.processor.IProcessInput;
import org.wisdomplanet.foundation.processor.IProcessOutput;
import org.wisdomplanet.model.EventDatum;
import org.wisdomplanet.model.EventObject;
import org.wisdomplanet.service.transform.*;
import org.wisdomplanet.service.transform.config.TransformContext;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yf on 2016/12/23.
 */
public class KafkaTransformProcessor extends BaseProcessor{

    private ITransform transform;

    private static AtomicLong index = new AtomicLong(0);

    public KafkaTransformProcessor(ITransform transform,TransformContext context) throws Exception{
        this.transform = transform;
        transform.init(context);
    }

    public void processKafka(EventDatum eventDatum, IProcessInput input, IProcessOutput output) throws Exception {
        TransformInput transformInput=new TransformInput(eventDatum);
        TransformOutput transformOutput=new TransformOutput();
        transform.transform(transformInput,transformOutput);
        System.out.println("TransformProcessor process task:" + Thread.currentThread().getId() + "  " + index.get());
        for (EventObject eo : transformOutput.getEventObjects()) {
            output.getCollector().collect(eo);
        }
    }
}
