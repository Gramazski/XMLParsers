package com.gramazski.xmlparsing.parser.impl;

import com.gramazski.xmlparsing.builder.impl.SAXBuilder;
import com.gramazski.xmlparsing.exception.BuilderInitializationException;
import com.gramazski.xmlparsing.exception.XMLBuildingException;
import com.gramazski.xmlparsing.parser.IXMLParser;
import com.gramazski.xmlparsing.entity.Devices;
import org.apache.logging.log4j.Level;

/**
 * Created by gs on 07.02.2017.
 */
public class SAXParser implements IXMLParser {
    private SAXBuilder xmlBuilder;

    public SAXParser(){
        try {
            xmlBuilder = new SAXBuilder();
        } catch (BuilderInitializationException e) {
            logger.log(Level.ERROR, "SAXParser error: " + e.getMessage());
        }
    }

    public Devices parse(String fileName) {
        try {
            xmlBuilder.buildDevices(fileName);
        } catch (XMLBuildingException e) {
            logger.log(Level.ERROR, "SAXParser error: " + e.getMessage());
        }
        return xmlBuilder.getDevices();
    }
}
