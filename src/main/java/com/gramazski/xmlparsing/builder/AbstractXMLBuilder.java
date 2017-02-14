package com.gramazski.xmlparsing.builder;

import com.gramazski.xmlparsing.entity.Devices;
import com.gramazski.xmlparsing.exception.XMLBuildingException;

/**
 * Created by gs on 07.02.2017.
 */
public abstract class AbstractXMLBuilder {
    protected Devices devices;

    protected AbstractXMLBuilder(){
        devices = new Devices();
    }

    public Devices getDevices() {
        //Can be clone
        return devices;
    }

    public abstract void buildDevices(String fileName) throws XMLBuildingException;
}
