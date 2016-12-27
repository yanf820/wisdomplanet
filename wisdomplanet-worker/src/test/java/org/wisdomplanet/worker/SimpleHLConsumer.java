package org.wisdomplanet.worker;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.*;

/**
 * Created by admin on 2016/12/25.
 */
public class SimpleHLConsumer {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
//        props.put("bootstrap.servers", "192.168.110.128:9092");
        props.put("bootstrap.servers", "10.1.34.215:9092");
        props.put("group.id", "default");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
//        props.put("partition.assignment.strategy","range");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("im"));
        ObjectMapper mapper=new ObjectMapper();
//        while (true) {
        ConsumerRecords<byte[],byte[]> records = consumer.poll(Long.MAX_VALUE);
        System.out.println(records.count());
            for (ConsumerRecord<byte[], byte[]> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
            }
        consumer.close();
    }


    }


