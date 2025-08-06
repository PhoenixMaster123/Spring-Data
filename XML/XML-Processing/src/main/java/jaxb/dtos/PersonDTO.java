package jaxb.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDTO {
    @XmlElement
    private String name;
    @XmlElement
    private String country;
    @XmlElement
    private String city;

    public PersonDTO(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }
    public PersonDTO() {}
}
