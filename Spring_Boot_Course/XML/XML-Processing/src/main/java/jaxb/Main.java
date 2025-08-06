package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jaxb.dtos.AddressBook;
import jaxb.dtos.Order;
import jaxb.dtos.PersonDTO;
import jaxb.dtos.PersonInfoDTO;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
       // writeXml();

        readXml();
    }

    /*private static void readXml() throws JAXBException {
        JAXBContext addressContext = JAXBContext.newInstance(AddressBook.class);
        Unmarshaller unmarshaller = addressContext.createUnmarshaller();

        AddressBook parsed = (AddressBook) unmarshaller.unmarshal(System.in);

        System.out.println(parsed);
    }
     */
    private static void readXml() throws JAXBException {
        JAXBContext addressContext = JAXBContext.newInstance(AddressBook.class);
        Unmarshaller unmarshaller = addressContext.createUnmarshaller();

        // Path to your XML file
        File xmlFile = new File("src/main/resources/scratch.xml");

        // Unmarshal the XML directly from the file
        AddressBook parsed = (AddressBook) unmarshaller.unmarshal(xmlFile);

        System.out.println(parsed);
    }

    private static void writeXml() throws JAXBException {
        // Example of using JAXB to marshal a DTO to XML
        PersonDTO person = new PersonDTO("John Doe", "USA", "New York");

        JAXBContext jaxbContext = JAXBContext.newInstance(PersonDTO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();  // From DTOs to XML

        // Enable pretty printing
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(person, System.out);
        /*
        <xml...>
            <person>
                <name>John Doe</name>
                <country>USA</country>
                <city>New York</city>
            </person>
        </xml...>
         */

        JAXBContext infoJaxbContext = JAXBContext.newInstance(PersonInfoDTO.class);
        Marshaller marshallerInfo = infoJaxbContext.createMarshaller();  // From DTOs to XML

        // Enable pretty printing
        marshallerInfo.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Order order1 = new Order("12345", new BigDecimal("99.99"), LocalDate.now());
        Order order2 = new Order("67890", new BigDecimal("49.99"), LocalDate.now().minusDays(1));

        PersonInfoDTO personInfoDTO = new PersonInfoDTO(person, List.of(order1, order2));

        marshallerInfo.marshal(personInfoDTO, System.out);
    }
}
