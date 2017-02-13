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
    public Cooler createDevice(Map<String, String> attributes) {
        Cooler cooler = new Cooler();

        cooler.setName(attributes.get("name"));
        cooler.setPrice(BigInteger.valueOf(Long.valueOf(attributes.get("price"))));
        cooler.setPort(Port.fromValue(attributes.get("port")));
        //Create device origin
        Origin deviceOrigin = new Origin();
        deviceOrigin.setCountry(attributes.get("country"));
        deviceOrigin.setCity(attributes.get("city"));

        cooler.setOrigin(deviceOrigin);
        cooler.setNoiseLimit(BigInteger.valueOf(Long.valueOf(attributes.get("noiseLimit"))));
        cooler.setRotationSpeed(BigInteger.valueOf(Long.valueOf(attributes.get("rotationSpeed"))));
        cooler.setBrand(CoolerBrand.fromValue(attributes.get("brand")));

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
