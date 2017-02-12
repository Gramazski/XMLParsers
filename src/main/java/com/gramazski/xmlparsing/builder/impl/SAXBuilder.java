package com.gramazski.xmlparsing.builder.impl;

import com.gramazski.xmlparsing.builder.AbstractXMLBuilder;
import com.gramazski.xmlparsing.entity.Devices;
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

    public SAXBuilder(){
        super();
        deviceHandler = new DeviceHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(deviceHandler);
        } catch (SAXException e) {
            //Add logging
            //System.err.print("ошибка SAX парсера: " + e);
        }
    }

    //Will be removed
    public SAXBuilder(Devices devices){
        super(devices);
    }

    public void buildDevices(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }

        devices = deviceHandler.getDevices();
    }
}
