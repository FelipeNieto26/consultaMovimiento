package com.banreservas.account.movement.dtos.soap;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Root")
@RegisterForReflection
public class Root {

    public XmlResponses xmlResponses;

    public Root(){

    }

    public XmlResponses getXmlResponses() {
        return xmlResponses;
    }

    public void setXmlResponses(XmlResponses xmlResponses) {
        this.xmlResponses = xmlResponses;
    }
}
