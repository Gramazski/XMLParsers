package com.gramazski.xmlparsing.parser.impl;

import com.gramazski.xmlparsing.entity.Devices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gs on 14.02.2017.
 */
public class StAXParserTest {
    private static Devices devices;
    @Before
    public void init(){
        DOMParser domParser = new DOMParser();
        devices = domParser.parse("src/main/resources/shema/newDevices.xml");
    }

    @Test
    public void parse() throws Exception {
        StAXParser stAXParser = new StAXParser();

        Devices newDevices = stAXParser.parse("src/main/resources/shema/devices.xml");

        Assert.assertEquals("Parse test failed.", newDevices.getDevice().get(0).getDeviceId(), devices.getDevice().get(0).getDeviceId());
    }

}