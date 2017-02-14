package com.gramazski.xmlparsing.marshaller;

import com.gramazski.xmlparsing.entity.Devices;
import com.gramazski.xmlparsing.exception.XMLMarshallerException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by gs on 14.02.2017.
 */
public class XMLMarshaller {
    public void generateXML(Devices devices, String filePath) throws XMLMarshallerException{
        try {
            JAXBContext context = JAXBContext.newInstance(Devices.class);
            Marshaller m = context.createMarshaller();

            m.marshal(devices, new FileOutputStream(filePath));
        } catch (FileNotFoundException e) {
            throw new XMLMarshallerException("File " + filePath +" not found", e);
        } catch (JAXBException e) {
            throw new XMLMarshallerException("JAXB-content incorrect: " + e.getMessage(), e);
        }
    }
}
