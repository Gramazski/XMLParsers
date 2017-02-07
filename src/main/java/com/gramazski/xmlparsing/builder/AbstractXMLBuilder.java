package com.gramazski.xmlparsing.builder;

import com.gramazski.xmlparsing.entity.Devices;

/**
 * Created by gs on 07.02.2017.
 */
public abstract class AbstractXMLBuilder {
    protected Devices devices;

    protected AbstractXMLBuilder(){
        devices = new Devices();
    }

    protected AbstractXMLBuilder(Devices devices){
        //Can be clone
        this.devices = devices;
    }

    public Devices getDevices() {
        //Can be clone
        return devices;
    }

    //String -> File??
    public abstract void buildDevices(String fileName);
}
