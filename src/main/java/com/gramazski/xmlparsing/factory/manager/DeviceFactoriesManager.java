package com.gramazski.xmlparsing.factory.manager;

import com.gramazski.xmlparsing.entity.descriptor.EntityStringDescriptor;
import com.gramazski.xmlparsing.entity.hierarchy.Device;
import com.gramazski.xmlparsing.factory.DeviceFactory;
import com.gramazski.xmlparsing.factory.impl.CPUFactory;
import com.gramazski.xmlparsing.factory.impl.CoolerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gs on 12.02.2017.
 */
public class DeviceFactoriesManager {
    private Map<String, DeviceFactory> factoryMap;

    //Can be use as singleton
    public DeviceFactoriesManager(){
        factoryMap = new HashMap<String, DeviceFactory>();
        factoryMap.put("cooler", new CoolerFactory());
        factoryMap.put("cpu", new CPUFactory());
    }

    public Device createDevice(EntityStringDescriptor deviceDescriptor){
        DeviceFactory deviceFactory = getDeviceFactory(deviceDescriptor.getDeviceName());
        Device device = deviceFactory.createDevice(deviceDescriptor.getParameters(), deviceDescriptor.getAttributes());

        return device;
    }

    private DeviceFactory getDeviceFactory(String deviceName){
        if (factoryMap.containsKey(deviceName)){
            return factoryMap.get(deviceName);
        }
        //Create own exception
        throw new IllegalArgumentException("No such key");
    }
}
