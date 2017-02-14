package com.gramazski.xmlparsing.builder.impl;

import com.gramazski.xmlparsing.builder.AbstractXMLBuilder;
import com.gramazski.xmlparsing.exception.BuilderInitializationException;
import com.gramazski.xmlparsing.exception.XMLBuildingException;
import com.gramazski.xmlparsing.handler.DeviceHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by gs on 07.02.2017.
 */
public class SAXBuilder extends AbstractXMLBuilder {
    private DeviceHandler deviceHandler;
    private XMLReader reader;

    public SAXBuilder() throws BuilderInitializationException{
        super();
        deviceHandler = new DeviceHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(deviceHandler);
        } catch (SAXException e) {
            throw new BuilderInitializationException("Exception with SAXBuilder initialization.Course: " + e.getMessage(), e);
        }
    }

    public void buildDevices(String fileName) throws XMLBuildingException {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            throw new XMLBuildingException("SAX parsing problem: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new XMLBuildingException("I/O problem in SAX builder: " + e.getMessage(), e);
        }

        devices = deviceHandler.getDevices();
    }
}
