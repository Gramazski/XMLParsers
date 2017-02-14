package com.gramazski.xmlparsing.builder.impl;

import com.gramazski.xmlparsing.builder.AbstractXMLBuilder;
import com.gramazski.xmlparsing.entity.descriptor.EntityStringDescriptor;
import com.gramazski.xmlparsing.entity.hierarchy.Device;
import com.gramazski.xmlparsing.exception.XMLBuildingException;
import com.gramazski.xmlparsing.factory.manager.DeviceFactoriesManager;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by gs on 07.02.2017.
 */
public class StAXBuilder extends AbstractXMLBuilder {
    private XMLInputFactory inputFactory;
    private DeviceFactoriesManager factoriesManager;

    public StAXBuilder(){
        super();
        factoriesManager = new DeviceFactoriesManager();
        inputFactory = XMLInputFactory.newInstance();
    }

    public void buildDevices(String fileName) throws XMLBuildingException {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                     String name = reader.getLocalName();
                    if (isValidElementType(name)) {
                        Device device = buildStudent(reader);
                        devices.addDevice(device);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            throw new XMLBuildingException("StAX parsing error: " + ex.getMessage(), ex);
        } catch (FileNotFoundException ex) {
            throw new XMLBuildingException("File " + fileName + " not found.", ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                //Should be logging
            }
        }
    }

    private Device buildStudent(XMLStreamReader reader) throws XMLStreamException {
        EntityStringDescriptor deviceDescriptor = new EntityStringDescriptor(reader.getLocalName());
        addElementAttributes(deviceDescriptor, reader);
        String startName = reader.getLocalName();
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    deviceDescriptor.addAttribute(reader.getLocalName(), getXMLText(reader));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (startName.equals(reader.getLocalName())){
                        Device device = factoriesManager.createDevice(deviceDescriptor);
                        return device;
                    }
                    break;
            }
        }

        throw new XMLStreamException("Unknown element in tag Student");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private void addElementAttributes(EntityStringDescriptor deviceDescriptor, XMLStreamReader reader){
        for (int i = 0; i < reader.getAttributeCount(); i++){
            deviceDescriptor.addAttribute(reader.getAttributeLocalName(i), reader.getAttributeValue(i));
        }
    }

    private boolean isValidElementType(String elementName){
        return ("cooler".equals(elementName)) || ("cpu".equals(elementName));
    }
}
