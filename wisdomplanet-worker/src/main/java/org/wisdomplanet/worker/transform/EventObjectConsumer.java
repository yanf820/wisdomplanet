package org.wisdomplanet.worker.transform;

import java.io.File;
import java.io.FileWriter;

import org.wisdomplanet.foundation.processor.BaseProcessor;
import org.wisdomplanet.foundation.processor.IProcessInput;
import org.wisdomplanet.foundation.processor.IProcessOutput;
import org.wisdomplanet.model.EventObject;

public class EventObjectConsumer extends BaseProcessor {

	public void processDemoBean(EventObject b, IProcessInput input, IProcessOutput output) throws Exception {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + b);
		
		File f = new File("EventObject");
		FileWriter sb = new FileWriter(f, true);
		sb.write(b.toString()+"\r\n");
		sb.flush();
		sb.close();
	}
}
