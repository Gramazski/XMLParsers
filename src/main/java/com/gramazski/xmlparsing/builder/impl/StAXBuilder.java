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
        try (FileInputStream inputStream = new FileInputStream(new File(fileName))) {

            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                     String name = reader.getLocalName();
                    if (isValidElementType(name)) {
                        Device device = buildDevice(reader);
                        devices.addDevice(device);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            throw new XMLBuildingException("StAX parsing error: " + ex.getMessage(), ex);
        } catch (FileNotFoundException ex) {
            throw new XMLBuildingException("File " + fileName + " not found.", ex);
        } catch (IOException ex){
            throw new XMLBuildingException("I/O error in StAX parsing", ex);
        }
    }

    private Device buildDevice(XMLStreamReader reader) throws XMLStreamException {
        String startName = reader.getLocalName();
        EntityStringDescriptor deviceDescriptor = new EntityStringDescriptor(startName);

        addElementAttributes(deviceDescriptor, reader);

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    String content = getXMLText(reader);

                    if (!"".equals(content.trim())){
                        deviceDescriptor.addAttribute(name, content);
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (startName.equals(reader.getLocalName())){
                        Device device = factoriesManager.createDevice(deviceDescriptor);
                        return device;
                    }
                    break;
            }
        }

        throw new XMLStreamException("Unknown element in tag " + startName);
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = "";
        if (reader.hasNext()) {
            reader.next();
            if (reader.hasText()){
                text = reader.getText();
            }
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
