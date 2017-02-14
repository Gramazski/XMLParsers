package com.gramazski.xmlparsing.parser.impl;

import com.gramazski.xmlparsing.builder.impl.StAXBuilder;
import com.gramazski.xmlparsing.exception.XMLBuildingException;
import com.gramazski.xmlparsing.parser.IXMLParser;
import com.gramazski.xmlparsing.entity.Devices;
import org.apache.logging.log4j.Level;

/**
 * Created by gs on 07.02.2017.
 */
public class StAXParser implements IXMLParser {
    private StAXBuilder stAXBuilder;

    public StAXParser(){
        stAXBuilder = new StAXBuilder();
    }

    public Devices parse(String fileName) {
        try {
            stAXBuilder.buildDevices(fileName);
        } catch (XMLBuildingException e) {
            logger.log(Level.ERROR, "StAXParser error: " + e.getMessage());
        }

        return stAXBuilder.getDevices();
    }
}
