package softuni.exam.service;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;

public interface MountaineerService {

    boolean areImported();

    String readMountaineersFromFile() throws IOException;

	String importMountaineers() throws IOException, JAXBException;


}
