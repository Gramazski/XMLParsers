//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.12 at 03:54:38 PM AST 
//


package com.gramazski.xmlparsing.entity.attribute;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CoolerBrand.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CoolerBrand">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="STC"/>
 *     &lt;enumeration value="SuperMicro"/>
 *     &lt;enumeration value="Gembird"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CoolerBrand")
@XmlEnum
public enum CoolerBrand {

    STC("STC"),
    @XmlEnumValue("SuperMicro")
    SUPER_MICRO("SuperMicro"),
    @XmlEnumValue("Gembird")
    GEMBIRD("Gembird");
    private final String value;

    CoolerBrand(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CoolerBrand fromValue(String v) {
        for (CoolerBrand c: CoolerBrand.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}