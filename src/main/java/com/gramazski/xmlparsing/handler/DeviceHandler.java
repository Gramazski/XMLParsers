package com.gramazski.xmlparsing.handler;

import com.gramazski.xmlparsing.entity.Devices;
import com.gramazski.xmlparsing.entity.hierarchy.Device;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by gs on 07.02.2017.
 */
public class DeviceHandler extends DefaultHandler {
    private Devices devices;
    private Device current = null;
    //private StudentEnum currentEnum = null;
    //private EnumSet<StudentEnum> withText;
    public DeviceHandler() {
        devices = new Devices();
        //withText = EnumSet.range(StudentEnum.NAME, StudentEnum.STREET);
    }
    public Devices getDevices() {
        return devices;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        //Just test
        System.out.print("ошибка SAX парсера: ");
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        //Just test
        System.out.print("ошибка SAX парсера: ");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        //Just test
        System.out.print("ошибка SAX парсера: ");
    }
}
