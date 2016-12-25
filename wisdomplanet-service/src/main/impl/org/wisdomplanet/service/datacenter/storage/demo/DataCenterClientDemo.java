/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: DataCenterClient.java
 * @Prject: wisdom-service
 * @Package: com.wisdom.service.transformaition
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-02
 * @version: V1.0  
 */
package org.wisdomplanet.service.datacenter.storage.demo;

import org.wisdomplanet.foundation.message.JsonMessageSerializer;
import org.wisdomplanet.foundation.message.KafkaMessageConsumer;
import org.wisdomplanet.foundation.message.MessageTopic;
import org.wisdomplanet.foundation.uuid.UUIDGenerator;
import org.wisdomplanet.model.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: DataCenterClient
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-02
 */
public class DataCenterClientDemo {
	
	@SuppressWarnings("serial")
	public List<EventModel> getEventModels(){
		return loadAllEventModels();
//		return new ArrayList<EventModel>(){{
//			add(loadEventModel());
//		}};
	}
	

	@SuppressWarnings("serial")
	public EventModel loadEventModel(){
		EventModel em = new EventModel();
		em.setId("testEm");
		em.setName("测试事件模型1");
		em.setChannels(new ArrayList<Channel>(){{
			add(new Channel("testEm.channel","","","log",new ArrayList<ChannelMapping>(){{
				add(new ChannelMapping("name","="));
				add(new ChannelMapping("browser", "="));
			}}));
		}});
		em.setFields(new ArrayList<Field>(){{
			add(new Field("name"));
		}});
		return em;
	}

	public List<EventModel> loadAllEventModels(){
		List<EventModel> eventModels=new ArrayList<EventModel>();
		EventModel loginEventModel=new EventModel(){{
			setId("EM-LOGIN");
			setName("登陆事件模型");
			setTitle("登陆");
			setDesc("用于登陆数据到事件的转换");
			setType("login");
			setFields(new ArrayList<Field>(){{
				add(new Field("userId"));
				add(new Field("location"));
				add(new Field("ip"));
				add(new Field("terminal"));
			}});
			setChannels(new ArrayList<Channel>(){{
			    add(new Channel("login-default","管道","默认管道","login",
						new ArrayList<ChannelMapping>(){{
							add(new ChannelMapping("userId","="));
							add(new ChannelMapping("location","="));
							add(new ChannelMapping("ip","="));
							add(new ChannelMapping("terminal","="));
						}}));
            }});
		}};

		EventModel consumeEventModel=new EventModel(){{
		    setId("EM-CONSUME");
		    setName("消费事件模型");
		    setTitle("消费");
		    setDesc("用于消费数据到事件的转换");
		    setType("consume");
		    setFields(new ArrayList<Field>(){{
		        add(new Field("userId"));
		        add(new Field("amount"));
		        add(new Field("orderId"));
            }});
			setChannels(new ArrayList<Channel>(){{
				add(new Channel("consume-default","管道","默认管道","consume",
						new ArrayList<ChannelMapping>(){{
							add(new ChannelMapping("userId","="));
							add(new ChannelMapping("amount","="));
							add(new ChannelMapping("orderId","="));
						}}));
			}});
        }};

		eventModels.add(loginEventModel);
		eventModels.add(consumeEventModel);

		return eventModels;
	}

	/**
	 * 假设每一个topic对应一类源数据，该类数据对应的EventDatum的tags，ip等元数据都应该根据topic从dataCenter中查
	 * @param messageTopic
	 * @return
	 */
	public EventDatum getBaseEventDatumByTopic(final MessageTopic messageTopic){
		return new EventDatum(){{
			setId(UUIDGenerator.randomUUID());
			setHost("www.datumSource.com");
			setIp("192.168.110.128");
			setTime(new Timestamp(System.currentTimeMillis()));
			setTags("login".equals(messageTopic.getTopicName())? "login" : "consume");
		}};

	}

    /**
     * 从datacenter中加载KafkaMessageConsumer元数据
     * @return
     */
	public KafkaMessageConsumer loadKafkaConsume(){
        KafkaMessageConsumer kafkaMessageConsumer=new KafkaMessageConsumer();
        kafkaMessageConsumer.setConnectList("192.168.110.128:2181");
        kafkaMessageConsumer.setSerializer(new JsonMessageSerializer());
        return kafkaMessageConsumer;
	}

}
