package org.wisdomplanet.worker.transform;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.wisdomplanet.foundation.processor.BaseProcessor;
import org.wisdomplanet.foundation.processor.ICollector;
import org.wisdomplanet.foundation.processor.IProcessInput;
import org.wisdomplanet.foundation.processor.IProcessOutput;
import org.wisdomplanet.foundation.uuid.UUIDGenerator;
import org.wisdomplanet.model.EventDatum;


public class EventDatumProducer extends BaseProcessor {
	
//	private IMessageConsumer messageConsumer;
//
//	@Override
//	protected Object[] handleMessageList(@SuppressWarnings("rawtypes") List list) {
//		if(list.get(0).equals("Random")){
//			return (new ArrayList<EventDatum>(){{
//				add(getEventDatum());
//			}}).toArray();
//		}else{
//			return list.toArray();
//		}
//    }
	
	
	@Override
    protected void produce(IProcessInput input, IProcessOutput output) throws Exception {
        ICollector collector = output.getCollector();
        collector.collect(getEventDatum());

    }
	

	/**
	 * @return
	 */
	private EventDatum getEventDatum() {
		EventDatum ed = new EventDatum();
		ed.setId(UUIDGenerator.randomUUID());
		ed.setIp("192.168.1.3");
		ed.setHost("wisdom.com");
		ed.setTime(new Timestamp(System.currentTimeMillis()));
		ed.setTags("log");
		Map<String,String> a = new HashMap<String,String>();
		a.put("name","zhangsan");
		a.put("browser","index.html");
		ed.setDataMap(a);
		return ed;
	}
    
    
    
}
