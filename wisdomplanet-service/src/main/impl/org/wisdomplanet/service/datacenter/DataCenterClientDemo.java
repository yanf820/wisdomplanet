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
package org.wisdomplanet.service.datacenter;

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
		List<EventModel> ems = new ArrayList<EventModel>(){{
			add(loadEventModel());
		}};
		return ems;
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

}
