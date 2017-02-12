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
    public CPU createDevice(String data, Map<String, String> attributes) {
        String[] parameters = data.split(";");
        CPU newCPU = new CPU();

        newCPU.setName(parameters[0]);
        newCPU.setPrice(BigInteger.valueOf(Long.valueOf(parameters[1])));
        newCPU.setPort(Port.valueOf(parameters[2]));
        //Create device origin
        Origin deviceOrigin = new Origin();
        deviceOrigin.setCountry(parameters[3]);
        deviceOrigin.setCity(parameters[4]);

        newCPU.setOrigin(deviceOrigin);
        newCPU.setCrystal(CrystalCodeName.fromValue(parameters[5]));
        newCPU.setFrequency(BigInteger.valueOf(Long.valueOf(parameters[6])));
        newCPU.setCoresNumber(BigInteger.valueOf(Long.valueOf(parameters[7])));
        //Create CPU complex name
        CPUComplexName complexName = new CPUComplexName();
        complexName.setBrand(CPUBrand.fromValue(parameters[8]));
        complexName.setModel(parameters[9]);

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
