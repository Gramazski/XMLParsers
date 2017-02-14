package com.gramazski.xmlparsing.parser;

import com.gramazski.xmlparsing.entity.Devices;
import com.gramazski.xmlparsing.exception.XMLMarshallerException;
import com.gramazski.xmlparsing.marshaller.XMLMarshaller;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by gs on 07.02.2017.
 */
public interface IXMLParser {
    Logger logger = LogManager.getLogger(IXMLParser.class);
    Devices parse(String fileName);
    default void writeAsXML(Devices rootObject, String fileName){
        XMLMarshaller xmlMarshaller = new XMLMarshaller();
        try{
            xmlMarshaller.generateXML(rootObject, fileName);
        }
        catch (XMLMarshallerException ex){
            logger.log(Level.ERROR, ex.getMessage());
        }
    }
}
