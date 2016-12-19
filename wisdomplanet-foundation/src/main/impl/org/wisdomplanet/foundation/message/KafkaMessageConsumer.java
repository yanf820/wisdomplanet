package org.wisdomplanet.foundation.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

/**
 */
public class KafkaMessageConsumer implements IMessageConsumer {

    private IMessageSerializer serializer;
    private String connectList;
    private String groupId;
    private ConsumerConnector consumerConnector;

    public String getConnectList() {
        return connectList;
    }

    public void setConnectList(String connectList) {
        this.connectList = connectList;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void __init__() {
        Properties properties = new Properties();
        properties.setProperty("zookeeper.connect", this.connectList); //127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183
        properties.setProperty("group.id", this.groupId == null ? "default" : this.groupId);
        properties.setProperty("zookeeper.clue.timeout.ms", "400");
        properties.setProperty("zookeeper.sync.time.ms", "200");
        properties.setProperty("auto.commit.interval.ms", "1000");
        properties.setProperty("auto.offset.reset", "smallest");
        ConsumerConfig consumerConfig = new ConsumerConfig(properties);
        this.consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);
    }

    @Override
    public void setSerializer(IMessageSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public <T> List<T> receive(MessageTopic topic, Class<T> messageType, int size) throws Exception {

        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic.getTopicName(), new Integer(size>0?size:1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = this.consumerConnector.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream =  consumerMap.get(topic.getTopicName()).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();

        List<T> msgs = new ArrayList<T>();

        while(it.hasNext()){
            MessageAndMetadata<byte[], byte[]> mm = it.next();
            T msgObj = this.serializer.deserialize(mm.message(), messageType);
            msgs.add(msgObj);
        }

        return msgs;
    }
}
