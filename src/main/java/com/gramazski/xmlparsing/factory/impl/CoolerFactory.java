package com.gramazski.xmlparsing.factory.impl;

import com.gramazski.xmlparsing.entity.attribute.CoolerAppointment;
import com.gramazski.xmlparsing.entity.attribute.CoolerBrand;
import com.gramazski.xmlparsing.entity.attribute.Origin;
import com.gramazski.xmlparsing.entity.attribute.Port;
import com.gramazski.xmlparsing.entity.hierarchy.Cooler;
import com.gramazski.xmlparsing.factory.DeviceFactory;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created by gs on 12.02.2017.
 */
public class CoolerFactory extends DeviceFactory {
    public Cooler createDevice(String data, Map<String, String> attributes) {
        String[] parameters = data.split(";");
        Cooler cooler = new Cooler();

        cooler.setName(parameters[0]);
        cooler.setPrice(BigInteger.valueOf(Long.valueOf(parameters[1])));
        cooler.setPort(Port.fromValue(parameters[2]));
        //Create device origin
        Origin deviceOrigin = new Origin();
        deviceOrigin.setCountry(parameters[3]);
        deviceOrigin.setCity(parameters[4]);

        cooler.setOrigin(deviceOrigin);
        cooler.setNoiseLimit(BigInteger.valueOf(Long.valueOf(parameters[5])));
        cooler.setRotationSpeed(BigInteger.valueOf(Long.valueOf(parameters[6])));
        cooler.setBrand(CoolerBrand.fromValue(parameters[7]));

        addAttributes(cooler, attributes);

        return cooler;
    }

    private void addAttributes(Cooler cooler, Map<String, String> attributes){
        if (attributes.containsKey("type")){
            cooler.setType(attributes.get("type"));
        }

        cooler.setDeviceId(attributes.get("deviceId"));
        cooler.setAppointment(CoolerAppointment.fromValue(attributes.get("appointment")));
    }
}