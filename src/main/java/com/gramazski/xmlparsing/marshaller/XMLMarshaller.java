package com.gramazski.xmlparsing.marshaller;

import com.gramazski.xmlparsing.entity.Devices;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by gs on 14.02.2017.
 */
public class XMLMarshaller {
    public void generateXML(Devices devices, String filePath){
        try {
            JAXBContext context = JAXBContext.newInstance(Devices.class);
            Marshaller m = context.createMarshaller();

            m.marshal(devices, new FileOutputStream(filePath));
            m.marshal(devices, System.out);
            System.out.println("XML-файл создан");
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
