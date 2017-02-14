package com.gramazski.xmlparsing.builder.impl;

import com.gramazski.xmlparsing.entity.Devices;
import com.gramazski.xmlparsing.exception.BuilderInitializationException;
import com.gramazski.xmlparsing.exception.XMLBuildingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gs on 12.02.2017.
 */
public class SAXBuilderTest {
    private static Devices devices;
    @Before
    public void init(){
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.buildDevices("src/main/resources/shema/devices.xml");
            devices = saxBuilder.getDevices();
        }
        catch (BuilderInitializationException ex){
            Assert.fail(ex.getMessage());
        }
        catch (XMLBuildingException ex){
            Assert.fail(ex.getMessage());
        }
    }
    @Test
    public void buildDevices() throws Exception {
        String actualName = "Third";
        Assert.assertTrue("Build device test failed.", devices.getDevice().get(0).getName().equals(actualName));
    }

}