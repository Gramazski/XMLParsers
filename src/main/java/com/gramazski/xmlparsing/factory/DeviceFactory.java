package com.gramazski.xmlparsing.factory;

import com.gramazski.xmlparsing.entity.hierarchy.Device;

/**
 * Created by gs on 12.02.2017.
 */
public abstract class DeviceFactory {
    public abstract Device createDevice(String data);
}
