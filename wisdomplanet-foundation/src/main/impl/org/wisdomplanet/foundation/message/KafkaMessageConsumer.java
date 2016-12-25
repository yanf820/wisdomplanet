package org.wisdomplanet.foundation.message;

import com.fasterxml.jackson.databind.JsonNode;
import kafka.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 *
 */
public class KafkaMessageConsumer implements IMessageConsumer {

    private IMessageSerializer serializer;
    private String connectList;
    private String groupId;
    private KafkaConsumer<String,String> consumer;

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
//        Properties properties = new Properties();
//        properties.setProperty("zookeeper.connect", this.connectList); //127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183
//        properties.setProperty("group.id", this.groupId == null ? "default" : this.groupId);
//        properties.setProperty("zookeeper.clue.timeout.ms", "400");
//        properties.setProperty("zookeeper.sync.time.ms", "200");
//        properties.setProperty("auto.commit.interval.ms", "1000");
//        properties.setProperty("auto.offset.reset", "smallest");
//        ConsumerConfig consumerConfig = new ConsumerConfig(properties);
//        this.consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);
        Properties props = new Properties();
        props.put("zookeeper.connect","192.168.110.128:2181");
        props.put("bootstrap.servers", "192.168.110.128:9092");
        props.put("group.id", "default");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        ConsumerConfig consumerConfig = new ConsumerConfig(props);
        this.consumer = new KafkaConsumer<>(props);
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
    }

    @Override
    public void setSerializer(IMessageSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public <T> List<T> receive(MessageTopic topic, Class<T> messageType, int size) throws Exception {

//        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
//        topicCountMap.put(topic.getTopicName(), new Integer(size>0?size:1));
//        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = this.consumerConnector.createMessageStreams(topicCountMap);
//        KafkaStream<byte[], byte[]> stream =  consumerMap.get(topic.getTopicName()).get(0);
//        ConsumerIterator<byte[], byte[]> it = stream.iterator();
//
//        List<T> msgs = new ArrayList<T>();
//
//        while(it.hasNext()){
//            MessageAndMetadata<byte[], byte[]> mm = it.next();
//            T msgObj = this.serializer.deserialize(mm.message(), messageType);
//            msgs.add(msgObj);
//        }
//
//        return msgs;
        return null;
    }

    @Override
    public List<JsonNode> receiveJson(MessageTopic topic, int size) throws IOException {

        consumer.subscribe(Arrays.asList(topic.getTopicName()));
        List<JsonNode> msgs = new ArrayList<>();

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
                msgs.add(this.serializer.deserializeToJson(new String(record.value()).getBytes()));
            }
            if (msgs.size() >= size){
                break;
            }
        }
        return msgs;
    }
}
