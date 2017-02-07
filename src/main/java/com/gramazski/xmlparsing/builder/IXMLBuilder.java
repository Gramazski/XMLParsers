package com.gramazski.xmlparsing.builder;

import com.gramazski.xmlparsing.entity.Devices;

/**
 * Created by gs on 07.02.2017.
 */
public interface IXMLBuilder {
    //Will be changed on root type
    Devices parse();
    //String -> File??
    void writeAsXML(Devices rootObject, String fileName);
}
