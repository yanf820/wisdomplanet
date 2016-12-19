/**  
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IMessageProducer.java
 * @Prject: wisdomplanet-foundation
 * @Package: org.wisdomplanet.foundation.message
 * @Description: TODO
 * @author: A.Z  
 * @date: 2016-12-05
 * @version: V1.0  
 */
package org.wisdomplanet.foundation.message;

/**
 * @ClassName: IMessageProducer
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public interface IMessageProducer {

    public void setSerializer(IMessageSerializer serializer);

    public void send(MessageTopic topic, Object ... messages) throws Exception;

}
