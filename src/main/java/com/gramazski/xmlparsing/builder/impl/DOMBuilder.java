package com.gramazski.xmlparsing.builder.impl;

import com.gramazski.xmlparsing.builder.AbstractXMLBuilder;
import com.gramazski.xmlparsing.entity.Devices;

/**
 * Created by gs on 07.02.2017.
 */
public class DOMBuilder extends AbstractXMLBuilder {
    public DOMBuilder(){
        super();
    }

    public DOMBuilder(Devices devices){
        super(devices);
    }

    public void buildDevices(String fileName) {

    }
}
