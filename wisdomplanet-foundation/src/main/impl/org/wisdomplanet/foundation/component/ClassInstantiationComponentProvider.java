package org.wisdomplanet.foundation.component;

/**
 */
public class ClassInstantiationComponentProvider implements IComponentProvider {

    @Override
    public Object getComponent(String componentId) {

        try {
            Class<?> clz = this.getClass().forName(componentId, true, this.getClass().getClassLoader());
            if(clz!=null){
                return clz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
