package com.gramazski.xmlparsing.entity.descriptor;

/**
 * Created by gs on 12.02.2017.
 */
public class EntityStringDescriptor {
    private String deviceName;
    private String parameters;

    public EntityStringDescriptor(String deviceName){
        this.deviceName = deviceName;
        this.parameters = "";
    }

    public void addParameter(String parameter){
        parameters += parameter + ";";
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getParameters() {
        return parameters;
    }
}
