package org.wisdomplanet.worker;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by admin on 2016/12/25.
 */
public class SimpleHLConsumer {
//    public static void main(String[] args) throws IOException {
//        Properties props = new Properties();
//        props.put("zookeeper.connect","192.168.110.128:2181");
//        props.put("bootstrap.servers", "192.168.110.128:9092");
//        props.put("group.id", "default");
//        props.put("enable.auto.commit", "true");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("session.timeout.ms", "30000");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(Arrays.asList("im"));
//        ObjectMapper mapper=new ObjectMapper();
////        while (true) {
//            ConsumerRecords<byte[], byte[]> records = consumer.poll(Long.MAX_VALUE);
//            for (ConsumerRecord<byte[], byte[]> record : records)
//                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
////        }
//    }

}
