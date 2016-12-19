package org.wisdomplanet.foundation.message;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 */
public class RedisMessageConsumer implements IMessageConsumer, Serializable {

    private String host;
    private int port;
    private IMessageSerializer serializer;
    private JedisPool pool;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void __init__() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        this.pool = new JedisPool(poolConfig, this.host, this.port);
    }

    @Override
    public void setSerializer(IMessageSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public <T> List<T> receive(MessageTopic topic, Class<T> messageType, int size) throws Exception {
        Jedis resource = this.pool.getResource();
        List<T> list = new ArrayList<T>();
        byte[] key = topic.getTopicName().getBytes(Charset.forName("UTF-8"));
        for(int i=0;i<size;i++){
            byte[] bytes = resource.lpop(key);
            if(bytes!=null){
                T v = this.serializer.deserialize(bytes, messageType);
                if(v!=null){
                    list.add(v);
                }
            }
        }

        resource.close();
        return list;
    }
}
