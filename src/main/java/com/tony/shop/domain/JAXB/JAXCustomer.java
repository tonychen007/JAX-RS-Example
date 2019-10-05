package com.tony.shop.domain.JAXB;


import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JAXCustomer {

    @XmlAttribute
    private int id;

    @XmlElement
    private String name;

    @XmlElement(name = "JAXAddress")
    private JAXAddress address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JAXAddress getAddress() {
        return address;
    }

    public void setAddress(JAXAddress address) {
        this.address = address;
    }
}
