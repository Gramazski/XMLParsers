package com.gramazski.xmlparsing.parser;

/**
 * Created by gs on 07.02.2017.
 */
public interface IXMLBuilder {
    //Will be changed on root type
    Object parse();
    //String -> File??
    void writeAsXML(Object rootObject, String fileName);
}
