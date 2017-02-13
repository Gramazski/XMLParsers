package com.gramazski.xmlparsing.factory;

import com.gramazski.xmlparsing.entity.hierarchy.Device;

import java.util.Map;

/**
 * Created by gs on 12.02.2017.
 */
public abstract class DeviceFactory {
    public abstract Device createDevice(Map<String, String> attributes);
}
