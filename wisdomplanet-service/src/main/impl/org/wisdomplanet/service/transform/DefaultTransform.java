/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: Transform.java
 * @Prject: wisdom-service
 * @Package: com.wisdom.service.transform
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-04
 * @version: V1.0  
 */
package org.wisdomplanet.service.transform;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wisdomplanet.model.Channel;
import org.wisdomplanet.model.ChannelMapping;
import org.wisdomplanet.model.EventDatum;
import org.wisdomplanet.model.EventModel;
import org.wisdomplanet.model.EventObject;
import org.wisdomplanet.service.datacenter.DataCenterClientDemo;
import org.wisdomplanet.service.provider.IEventObjectProvider;
import org.wisdomplanet.service.transform.config.TransformContext;
import org.wisdomplanet.service.transform.mapper.ChannelMapper;


/**
 * @ClassName: Transform
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-04
 */
public class DefaultTransform extends BaseTransform{
	
	private DataCenterClientDemo dc;
	private ChannelMapper cmr;

	/* (non Javadoc)
	 * @Title: init
	 * @Description: TODO
	 * @param context
	 * @throws Exception
	 * @see com.wisdom.service.transform.BaseTransform#init(com.wisdom.service.transform.TransformerContext)
	 */
	@Override
	public void init(TransformContext context) throws Exception {
		super.init(context);
		this.dc = context.getDataCenterClient();
		this.cmr = context.getChannelMapper();
	}

	/* (non Javadoc)
	 * @Title: transformDatum
	 * @Description: TODO
	 * @param eventDatum
	 * @param eventModel
	 * @param output
	 * @see com.wisdom.service.transform.BaseTransform#transformDatum(com.wisdom.model.EventDatum, com.wisdom.model.EventModel, com.wisdom.service.transform.ITransformOutput)
	 */
	@Override
	protected void transformDatum(final EventDatum eventDatum, EventModel eventModel, ITransformOutput output)
			throws Exception {
		for (Channel channel : eventModel.getChannels()) {
			if (eventDatum.getTags().equals(channel.getTags())) {
				Map<String, String> variableMap = new HashMap<String, String>();
				for (ChannelMapping cm : channel.getMappings()) {
					variableMap.put(cm.getFieldName(),
							cmr.map(cm.getFieldName(), cm.getExpress(), eventDatum.getDataMap()));
				}
				final Map<String, String> vm = variableMap;
				output.output(new IEventObjectProvider() {
					@Override
					public void provide(EventObject obj) {
						obj.setId("transform" + eventDatum.getId());
						obj.setFields(vm);
						obj.setTimeStamp(new Timestamp(System.currentTimeMillis()));
					}
				});
			}
		}
	}

	/* (non Javadoc)
	 * @Title: getEventModel
	 * @Description: TODO
	 * @param tags
	 * @return
	 * @see com.wisdom.service.transform.BaseTransform#getEventModel(java.lang.String)
	 */
	@Override
	protected List<EventModel> getEventModel(String tags) {
		return this.dc.getEventModels();
	}
	
}
