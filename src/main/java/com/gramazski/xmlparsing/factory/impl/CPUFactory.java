package com.gramazski.xmlparsing.factory.impl;

import com.gramazski.xmlparsing.entity.attribute.*;
import com.gramazski.xmlparsing.entity.hierarchy.CPU;
import com.gramazski.xmlparsing.factory.DeviceFactory;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created by gs on 12.02.2017.
 */
public class CPUFactory extends DeviceFactory {
    public CPU createDevice(Map<String, String> attributes) {
        CPU newCPU = new CPU();

        newCPU.setName(attributes.get("name"));
        newCPU.setPrice(BigInteger.valueOf(Long.valueOf(attributes.get("price"))));
        newCPU.setPort(Port.valueOf(attributes.get("port")));
        //Create device origin
        Origin deviceOrigin = new Origin();
        deviceOrigin.setCountry(attributes.get("country"));
        deviceOrigin.setCity(attributes.get("city"));

        newCPU.setOrigin(deviceOrigin);
        newCPU.setCrystal(CrystalCodeName.fromValue(attributes.get("crystal")));
        newCPU.setFrequency(BigInteger.valueOf(Long.valueOf(attributes.get("frequency"))));
        newCPU.setCoresNumber(BigInteger.valueOf(Long.valueOf(attributes.get("coresNumber"))));
        //Create CPU complex name
        CPUComplexName complexName = new CPUComplexName();
        complexName.setBrand(CPUBrand.fromValue(attributes.get("brand")));
        complexName.setModel(attributes.get("model"));

        newCPU.setComplexName(complexName);
        addAttributes(newCPU, attributes);

        return newCPU;
    }

    private void addAttributes(CPU cpu, Map<String, String> attributes){
        if (attributes.containsKey("type")){
            cpu.setType(attributes.get("type"));
        }

        cpu.setDeviceId(attributes.get("deviceId"));
        cpu.setSocket(Socket.fromValue(attributes.get("socket")));
    }
}
