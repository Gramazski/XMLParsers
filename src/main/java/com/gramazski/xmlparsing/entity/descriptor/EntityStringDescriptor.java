package com.gramazski.xmlparsing.entity.descriptor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gs on 12.02.2017.
 */
public class EntityStringDescriptor {
    private String deviceName;
    private Map<String, String> attributes;

    public EntityStringDescriptor(String deviceName){
        this.deviceName = deviceName;
        this.attributes = new HashMap<String, String>();
    }

    public void addAttribute(String attributeName, String attribute){
        if (!attributes.containsKey(attributeName)){
            attributes.put(attributeName, attribute);
        }
    }

    public String getDeviceName() {
        return deviceName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
