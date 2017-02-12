//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2017.02.12 at 03:54:38 PM AST
//


package com.gramazski.xmlparsing.entity;

import com.gramazski.xmlparsing.entity.hierarchy.Device;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.example.com/devices}device" maxOccurs="unbounded" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "device"
})
@XmlRootElement(name = "devices")
public class Devices {

    @XmlElementRef(name = "device", namespace = "http://www.gramazski.com/xmlparsing/entity/devices", type = JAXBElement.class)
    protected List<Device> device;

    public Devices(){
        device = new ArrayList<Device>();
    }

    /**
     * Gets the value of the device property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the device property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDevice().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Device }{@code >}
     * {@link JAXBElement }{@code <}{@link CPU }{@code >}
     * {@link JAXBElement }{@code <}{@link Cooler }{@code >}
     *
     *
     */
    public List<Device> getDevice() {
        return this.device;
    }

    public void addDevice(Device device) {
        this.device.add(device);
    }
}
