package com.banreservas.account.movement.dtos.soap;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "XmlResponses")
@RegisterForReflection
public class XmlResponses {

    @XmlElement(name = "XmlResponse")
    private List<XmlResponse> xmlResponses;

    public XmlResponses (){

    }

    //Getters y Setters
    public List<XmlResponse> getXmlResponses() {
        return xmlResponses;
    }

    public void setXmlResponses(List<XmlResponse> xmlResponses) {
        this.xmlResponses = xmlResponses;
    }
}
