package org.wisdomplanet.foundation.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 */
public class SpringApplicationContextUtils {

    private static ApplicationContext applicationContext;
    private static String contextId;
    private static Object lockObj = new Object();

    public static String getContextId() {
        return contextId;
    }

    public static void setContextId(String contextId) {
        SpringApplicationContextUtils.contextId = contextId;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringApplicationContextUtils.applicationContext = applicationContext;
    }

    public static synchronized ApplicationContext getApplicationContext() {
        if(applicationContext!=null) {
            return applicationContext;
        }else{
            //synchronized (lockObj) {
                applicationContext = new ClassPathXmlApplicationContext(contextId == null ? "wisdomplanet.xml" : contextId);
                return applicationContext;
            //}
        }
    }

}
