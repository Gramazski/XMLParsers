package com.gramazski.xmlparsing.builder.impl;

import com.gramazski.xmlparsing.entity.Devices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gs on 14.02.2017.
 */
public class DOMBuilderTest {
    private static Devices devices;
    @Before
    public void init(){
        DOMBuilder domBuilder = new DOMBuilder();
        domBuilder.buildDevices("src/main/resources/shema/devices.xml");
        devices = domBuilder.getDevices();
    }
    @Test
    public void buildDevices() throws Exception {
        String actualName = "Third";
        Assert.assertTrue("Build device test failed.", devices.getDevice().get(0).getName().equals(actualName));
    }

}