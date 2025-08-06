package jaxb.dtos;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "person-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonInfoDTO {
    private PersonDTO person;

    @XmlElementWrapper(name = "order-list") // This will wrap the list in an XML element named "order-list"
    @XmlElement(name = "order") // Each order will be represented as an "order" element
    private List<Order> orders;

    public PersonInfoDTO() {}

    public PersonInfoDTO(PersonDTO person, List<Order> orders) {
        this.person = person;
        this.orders = orders;
    }
}
