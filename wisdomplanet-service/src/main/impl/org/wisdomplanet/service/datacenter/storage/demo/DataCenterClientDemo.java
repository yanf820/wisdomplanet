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

import java.util.ArrayList;
import java.util.List;

import org.wisdomplanet.model.Channel;
import org.wisdomplanet.model.ChannelMapping;
import org.wisdomplanet.model.EventModel;
import org.wisdomplanet.model.Field;


/**
 * @ClassName: DataCenterClient
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-02
 */
public class DataCenterClientDemo {
	
	@SuppressWarnings("serial")
	public List<EventModel> getEventModels(){
//		List<EventModel> ems = new ArrayList<EventModel>(){{
//			add(loadEventModel());
//		}};
		return loadAllEventModels();
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

    public static void main(String[] args) {
        DataCenterClientDemo demo=new DataCenterClientDemo(){{
            System.out.println(loadEventModel());
        }};
    }

}
