/**
 * Copyright © 2016 ETERNITY. All rights reserved.
 * @Title: IMessageSerializer.java
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

/**
 * @ClassName: IMessageSerializer
 * @Description: TODO
 * @author: A.Z
 * @date: 2016-12-05
 */
public interface IMessageSerializer {

    public byte[] serialize(Object message) throws IOException;

    public <T> T deserialize(byte[] messageBytes, Class<T> messageType) throws IOException;

    public JsonNode deserializeToJson(byte[] messageBytes) throws IOException;

}
