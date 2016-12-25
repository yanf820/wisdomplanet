/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IMessageConsumer.java
 * @Prject: wisdomplanet-foundation
 * @Package: org.wisdomplanet.foundation.message
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-05
 * @version: V1.0  
 */
package org.wisdomplanet.foundation.message;


import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName: IMessageConsumer
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public interface IMessageConsumer {

    public void setSerializer(IMessageSerializer serializer);

    public <T> List<T> receive(MessageTopic topic, Class<T> messageType, int size) throws Exception;

    public List<JsonNode> receiveJson(MessageTopic topic, int size) throws IOException;

}
