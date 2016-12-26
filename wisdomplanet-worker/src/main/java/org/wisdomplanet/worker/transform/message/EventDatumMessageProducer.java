package org.wisdomplanet.worker.transform.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import kafka.utils.Json;
import org.apache.sling.commons.json.JSONObject;
import org.wisdomplanet.foundation.message.MessageTopic;
import org.wisdomplanet.foundation.processor.MessageReceiveProducer;
import org.wisdomplanet.model.EventDatum;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yf on 2016/12/26.
 */
public class EventDatumMessageProducer extends MessageReceiveProducer{

    @Override
    protected Object[] handleMessageList(final List list) {

        return new ArrayList<EventDatum>(){{

            for (Object o:list){
                add((EventDatum) o);
            }
        }}.toArray();
    }

    public static void main(String[] args) throws JsonProcessingException {
//        EventDatumMessageProducer eventDatumMessageProducer =new EventDatumMessageProducer();
//        Object[] objects = eventDatumMessageProducer.handleMessageList(new ArrayList(){{
//            add(new MessageTopic(){{
//                setTopicName("yan");
//            }});
//        }});
//
//        System.out.println(objects.getClass());
        EventDatum eventDatum=new EventDatum();
        eventDatum.setId("UUUJQWLLS");
        eventDatum.setHost("www.ed.com");
        eventDatum.setIp("192.168.1.1");
        eventDatum.setTime(new Timestamp(System.currentTimeMillis()));
        eventDatum.setTags("login");
        eventDatum.setDataMap(new HashMap<String, String>(){{
            put("id","12");
            put("name","login-datum");
        }});

        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(eventDatum));


    }
}
