package com.gramazski.xmlparsing.builder.impl;

import com.gramazski.xmlparsing.builder.AbstractXMLBuilder;
import com.gramazski.xmlparsing.entity.descriptor.EntityStringDescriptor;
import com.gramazski.xmlparsing.entity.hierarchy.Device;
import com.gramazski.xmlparsing.factory.manager.DeviceFactoriesManager;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gs on 07.02.2017.
 */
public class DOMBuilder extends AbstractXMLBuilder {
    private DocumentBuilder documentBuilder;
    private List<String> requestedElementNameList;
    private DeviceFactoriesManager factoriesManager;

    public DOMBuilder(){
        super();
        requestedElementNameList = new ArrayList<String>();
        requestedElementNameList.add("cooler");
        requestedElementNameList.add("cpu");
        factoriesManager = new DeviceFactoriesManager();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public void buildDevices(String fileName) {
        Document doc = null;
        try {
            doc = documentBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            for (String elementName : requestedElementNameList) {
                NodeList devicesList = root.getElementsByTagName(elementName);
                for (int i = 0; i < devicesList.getLength(); i++) {
                    Element deviceElement = (Element) devicesList.item(i);
                    Device device = buildDevice(deviceElement, elementName);
                    devices.addDevice(device);
                }
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Device buildDevice(Element deviceElement, String deviceType) {

        Device device = factoriesManager.createDevice(createElementDescriptor(deviceElement, deviceType));

        return device;
    }

    private EntityStringDescriptor createElementDescriptor(Element deviceElement, String deviceType){
        EntityStringDescriptor deviceDescriptor = new EntityStringDescriptor(deviceType);
        NodeList childList = deviceElement.getChildNodes();
        addInnerElements(deviceDescriptor, childList);
        addElementAttributes(deviceDescriptor, deviceElement);

        return deviceDescriptor;
    }

    private void addInnerElements(EntityStringDescriptor deviceDescriptor, NodeList childList){
        for (int i = 0; i < childList.getLength(); i++){
            Node childElement = childList.item(i);
            NodeList tempChildList = childElement.getChildNodes();
            int a = tempChildList.getLength();
            if (tempChildList.getLength() > 1){
                addInnerElements(deviceDescriptor, tempChildList);
            } else if (!childElement.getNodeName().startsWith("#")){
                deviceDescriptor.addAttribute(childElement.getNodeName(), childElement.getTextContent());
            }
        }
    }

    private void addElementAttributes(EntityStringDescriptor deviceDescriptor, Element deviceElement){
        NamedNodeMap attributeMap = deviceElement.getAttributes();
        for (int i = 0; i < attributeMap.getLength(); i++){
            Node attributeNode = attributeMap.item(i);
            deviceDescriptor.addAttribute(attributeNode.getNodeName(), attributeNode.getTextContent());
        }
    }
}
