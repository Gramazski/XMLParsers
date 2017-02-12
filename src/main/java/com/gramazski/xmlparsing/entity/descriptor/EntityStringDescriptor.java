package com.gramazski.xmlparsing.entity.descriptor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gs on 12.02.2017.
 */
public class EntityStringDescriptor {
    private String deviceName;
    private String parameters;
    private Map<String, String> attributes;

    public EntityStringDescriptor(String deviceName){
        this.deviceName = deviceName;
        this.parameters = "";
        this.attributes = new HashMap<String, String>();
    }

    public void addParameter(String parameter){
        parameters += parameter + ";";
    }

    public void addAttribute(String attributeName, String attribute){
        if (!attributes.containsKey(attributeName)){
            attributes.put(attributeName, attribute);
        }
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getParameters() {
        return parameters;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
