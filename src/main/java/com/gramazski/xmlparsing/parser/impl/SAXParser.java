package com.gramazski.xmlparsing.parser.impl;

import com.gramazski.xmlparsing.builder.impl.SAXBuilder;
import com.gramazski.xmlparsing.parser.IXMLParser;
import com.gramazski.xmlparsing.entity.Devices;

/**
 * Created by gs on 07.02.2017.
 */
//Will be realized
public class SAXParser implements IXMLParser {
    private SAXBuilder xmlBuilder;

    public SAXParser(){
        xmlBuilder = new SAXBuilder();
    }

    public Devices parse(String fileName) {
        xmlBuilder.buildDevices(fileName);
        return xmlBuilder.getDevices();
    }

    public void writeAsXML(Devices rootObject, String fileName) {

    }
}
