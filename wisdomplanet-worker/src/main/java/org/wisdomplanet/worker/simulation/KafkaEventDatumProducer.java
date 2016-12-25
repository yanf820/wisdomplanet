package org.wisdomplanet.worker.simulation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.wisdomplanet.foundation.message.KafkaMessageConsumer;
import org.wisdomplanet.foundation.message.MessageTopic;
import org.wisdomplanet.foundation.processor.BaseProcessor;
import org.wisdomplanet.foundation.processor.IProcessInput;
import org.wisdomplanet.foundation.processor.IProcessOutput;
import org.wisdomplanet.model.EventDatum;
import org.wisdomplanet.service.datacenter.storage.demo.DataCenterClientDemo;

import java.util.List;
import java.util.Map;

/**
 * Created by yf on 2016/12/23.
 */
public class KafkaEventDatumProducer extends BaseProcessor{

    private DataCenterClientDemo dataCenterClient;

    private KafkaMessageConsumer kafkaMessageConsumer;

    public KafkaEventDatumProducer(DataCenterClientDemo dataCenterClient){
        this.dataCenterClient = dataCenterClient;
        this.kafkaMessageConsumer=this.dataCenterClient.loadKafkaConsume();
        kafkaMessageConsumer.__init__();
    }

    @Override
    protected void produce(IProcessInput input, IProcessOutput output) throws Exception {
        MessageTopic topic=new MessageTopic(){{
            setTopicName("im");
        }};

        List<JsonNode> receives=kafkaMessageConsumer.receiveJson(topic,3);

        for (JsonNode jsonNode:receives) {
            output.getCollector().collect(dataToEventDatum(jsonNode,topic));
        }

    }

    /**
     * 将kafka读取的数据改造为EventDatum
     * @param jsonNode
     * @param messageTopic
     * @return
     */
    private EventDatum dataToEventDatum(JsonNode jsonNode, MessageTopic messageTopic){

        EventDatum eventDatum = dataCenterClient.getBaseEventDatumByTopic(messageTopic);
        ObjectMapper mapper=new ObjectMapper();
        eventDatum.setDataMap(mapper.convertValue(jsonNode, Map.class));

        return eventDatum;
    }


}
