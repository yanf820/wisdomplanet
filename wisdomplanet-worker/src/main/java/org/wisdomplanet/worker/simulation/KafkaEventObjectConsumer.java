package org.wisdomplanet.worker.simulation;

import org.wisdomplanet.foundation.message.KafkaMessageProducer;
import org.wisdomplanet.foundation.processor.BaseProcessor;

/**
 * Created by admin on 2016/12/25.
 */
public class KafkaEventObjectConsumer extends BaseProcessor{

    private KafkaMessageProducer kafkaMessageProducer;

}
