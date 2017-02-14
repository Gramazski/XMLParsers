package com.gramazski.xmlparsing.parser.impl;

import com.gramazski.xmlparsing.builder.impl.DOMBuilder;
import com.gramazski.xmlparsing.exception.BuilderInitializationException;
import com.gramazski.xmlparsing.exception.XMLBuildingException;
import com.gramazski.xmlparsing.parser.IXMLParser;
import com.gramazski.xmlparsing.entity.Devices;
import org.apache.logging.log4j.Level;

/**
 * Created by gs on 07.02.2017.
 */
//Will be realized
public class DOMParser implements IXMLParser {
    private DOMBuilder domBuilder;

    public DOMParser(){
        try {
            domBuilder = new DOMBuilder();
        } catch (BuilderInitializationException e) {
            logger.log(Level.ERROR, "DOMParser error: " + e.getMessage());
        }
    }

    public Devices parse(String fileName) {
        try {
            domBuilder.buildDevices(fileName);
        } catch (XMLBuildingException e) {
            logger.log(Level.ERROR, "DOMParser error: " + e.getMessage());
        }

        return domBuilder.getDevices();
    }
}
