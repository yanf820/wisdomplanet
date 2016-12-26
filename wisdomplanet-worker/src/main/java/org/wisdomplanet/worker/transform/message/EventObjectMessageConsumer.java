package org.wisdomplanet.worker.transform.message;

import org.wisdomplanet.foundation.processor.MessageSendProcessor;
import org.wisdomplanet.model.EventObject;

import java.util.ArrayList;

/**
 * Created by yf on 2016/12/26.
 */
public class EventObjectMessageConsumer extends MessageSendProcessor{

    @Override
    protected Object[] handleObjectToMessages(final Object inputObject) {
        return new ArrayList<EventObject>(){{
         add((EventObject) inputObject);
        }}.toArray();
    }
}
