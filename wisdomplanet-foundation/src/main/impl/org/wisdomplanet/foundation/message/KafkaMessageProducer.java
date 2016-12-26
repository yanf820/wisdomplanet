package org.wisdomplanet.foundation.message;

import com.google.common.primitives.Longs;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 */
public class KafkaMessageProducer implements IMessageProducer {

    private IMessageSerializer serializer;
    private String brokerList;
    private Producer<byte[], byte[]> producer;
    private long messageKeyIndex;

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    public void __init__() {

        Properties properties = new Properties();
        properties.setProperty("serializer.class", "kafka.serializer.DefaultEncoder");
        properties.setProperty("metadata.broker.list", this.brokerList);

        this.messageKeyIndex = 0L;
        ProducerConfig config = new ProducerConfig(properties);
        this.producer = new Producer<byte[], byte[]>(config);
    }

    @Override
    public void setSerializer(IMessageSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public void send(MessageTopic topic, Object... messages) throws Exception {
        if(messages == null || messages.length == 0) return;
        List<KeyedMessage<byte[], byte[]>> msgs = new ArrayList<KeyedMessage<byte[], byte[]>>(messages.length);
        if(messages!=null) for(Object message : messages) {
            byte[] messageBody = this.serializer.serialize(message);
            long key = this.messageKeyIndex++;
            if(this.messageKeyIndex >= Long.MAX_VALUE) this.messageKeyIndex = 0L;
            KeyedMessage<byte[], byte[]> msg = new KeyedMessage<byte[], byte[]>(topic.getTopicName(), Longs.toByteArray(key), messageBody);
            msgs.add(msg);
        }
        this.producer.send(msgs);
    }
}
