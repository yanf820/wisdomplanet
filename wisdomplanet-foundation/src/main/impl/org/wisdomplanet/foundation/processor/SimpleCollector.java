package org.wisdomplanet.foundation.processor;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class SimpleCollector implements ICollector {

    private List<Object> collectedObjects;

    public SimpleCollector() {
        this.collectedObjects = new ArrayList<Object>();
    }

    @Override
    public void collect(Object object) {
        if(object != null) {
            this.collectedObjects.add(object);
        }
    }

    public Object[] toArray() {
        return this.collectedObjects.toArray();
    }

    public List<Object> toList() {
        return this.collectedObjects;
    }

    public int getSize() {
        return this.collectedObjects.size();
    }
}
