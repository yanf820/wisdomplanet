package org.wisdomplanet.worker.transform.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.wisdomplanet.foundation.message.IMessageConsumer;
import org.wisdomplanet.foundation.message.IMessageSerializer;
import org.wisdomplanet.foundation.message.MessageTopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by admin on 2016/12/26.
 */
public class KafkaMessageConsumerNew implements IMessageConsumer{

    private IMessageSerializer serializer;
    private String connectList;
    private String groupId;
    private KafkaConsumer<byte[],byte[]> consumer;

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
        properties.put("bootstrap.servers", connectList);
        properties.setProperty("group.id", this.groupId == null ? "default" : this.groupId);
        properties.setProperty("zookeeper.clue.timeout.ms", "400");
        properties.setProperty("zookeeper.sync.time.ms", "200");
        properties.setProperty("auto.commit.interval.ms", "1000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        this.consumer = new KafkaConsumer<>(properties);
    }

    @Override
    public void setSerializer(IMessageSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public <T> List<T> receive(MessageTopic topic, Class<T> messageType, int size) throws Exception {
        consumer.subscribe(Arrays.asList(topic.getTopicName()));
        List<T> msgs=new ArrayList<>();
        while (true){
            ConsumerRecords<byte[],byte[]> records = consumer.poll(Long.MAX_VALUE);
            for (ConsumerRecord<byte[],byte[]> record:records){
                T msg=serializer.deserialize(record.value(),messageType);
                System.out.println(msg);
                msgs.add(msg);
            }

            if (msgs.size()>=size){
                break;
            }
        }
        return msgs;
    }
}
