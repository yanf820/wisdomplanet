package org.wisdomplanet.foundation.component;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;


/**
 */
public class SpringComponentProvider implements IComponentProvider , Serializable{

    private static final long serialVersionUID = 1684227928905153462L;


    @Override
    public Object getComponent(String componentId) {
        ApplicationContext applicationContext = SpringApplicationContextUtils.getApplicationContext();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + applicationContext);
        return applicationContext.getBean(componentId);
    }
}
