package com.gramazski.xmlparsing.parser;

import com.gramazski.xmlparsing.entity.Devices;

/**
 * Created by gs on 07.02.2017.
 */
public interface IXMLParser {
    //Will be changed on root type
    Devices parse(String fileName);
    void writeAsXML(Devices rootObject, String fileName);
}