package com.gramazski.xmlparsing.handler;

import com.gramazski.xmlparsing.entity.Devices;
import com.gramazski.xmlparsing.entity.descriptor.EntityStringDescriptor;
import com.gramazski.xmlparsing.factory.manager.DeviceFactoriesManager;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by gs on 07.02.2017.
 */
public class DeviceHandler extends DefaultHandler {
    private Devices devices;
    private EntityStringDescriptor descriptor;
    private DeviceFactoriesManager factoriesManager;
    private String currentInnerParameter;

    public DeviceHandler() {
        devices = new Devices();
        factoriesManager = new DeviceFactoriesManager();
        currentInnerParameter = "";
    }

    public Devices getDevices() {
        return devices;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (isValidElementType(localName)){
            descriptor = new EntityStringDescriptor(localName);
            for (int i = 0; i < attrs.getLength(); i++){
                descriptor.addAttribute(attrs.getLocalName(i), attrs.getValue(i));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ((descriptor != null) && (isValidElementType(localName))){
            devices.addDevice(factoriesManager.createDevice(descriptor));
        }

        if (!(currentInnerParameter.equals("")) && (descriptor != null)){
            descriptor.addAttribute(localName, currentInnerParameter);
            currentInnerParameter = "";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String parameter = new String(ch, start, length).trim();
        if ((descriptor != null) && (!parameter.equals(""))){
            currentInnerParameter = parameter;
        }
    }

    private boolean isValidElementType(String elementName){
        return ("cooler".equals(elementName)) || ("cpu".equals(elementName));
    }
}
