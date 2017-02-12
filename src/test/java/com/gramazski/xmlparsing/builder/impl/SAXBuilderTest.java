package com.gramazski.xmlparsing.builder.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by gs on 12.02.2017.
 */
public class SAXBuilderTest {
    @BeforeClass
    public static void init(){

    }
    @Test
    public void buildDevices() throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        saxBuilder.buildDevices("src/main/resources/shema/devices.xml");
        Assert.assertTrue(true);
    }

}