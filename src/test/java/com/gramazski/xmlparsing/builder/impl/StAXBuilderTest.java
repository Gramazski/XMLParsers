package com.gramazski.xmlparsing.builder.impl;

import com.gramazski.xmlparsing.entity.Devices;
import com.gramazski.xmlparsing.exception.XMLBuildingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gs on 14.02.2017.
 */
public class StAXBuilderTest {
    private static Devices devices;
    @Before
    public void init(){
        try {
            StAXBuilder staxBuilder = new StAXBuilder();
            staxBuilder.buildDevices("src/main/resources/shema/newDevices.xml");
            devices = staxBuilder.getDevices();
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