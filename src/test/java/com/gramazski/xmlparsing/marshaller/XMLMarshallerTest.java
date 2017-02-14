package com.gramazski.xmlparsing.marshaller;

import com.gramazski.xmlparsing.builder.impl.DOMBuilder;
import com.gramazski.xmlparsing.entity.Devices;
import com.gramazski.xmlparsing.exception.BuilderInitializationException;
import com.gramazski.xmlparsing.exception.XMLBuildingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gs on 14.02.2017.
 */
public class XMLMarshallerTest {
    private static Devices devices;
    @Before
    public void init(){
        try {
            DOMBuilder domBuilder = new DOMBuilder();
            domBuilder.buildDevices("src/main/resources/shema/devices.xml");
            devices = domBuilder.getDevices();
        }
        catch (BuilderInitializationException ex){
            Assert.fail(ex.getMessage());
        }
        catch (XMLBuildingException ex){
            Assert.fail(ex.getMessage());
        }

    }
    @Test
    public void generateXML() throws Exception {
        XMLMarshaller xmlMarshaller = new XMLMarshaller();
        xmlMarshaller.generateXML(devices, "src/main/resources/shema/newDevices1.xml");
        Assert.assertTrue(true);
    }

}