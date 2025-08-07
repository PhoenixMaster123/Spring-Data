package softuni.exam.import_Mountaineers;
//TestImportMountaineerZeroTest000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import jakarta.xml.bind.JAXBException;
import softuni.exam.service.impl.MountaineerServiceImpl;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestImportMountaineerZeroTest000 {

    @Autowired
    private MountaineerServiceImpl mountaineerService;

    @Sql({"/countries-test-imports.sql", "/mountains-test-imports.sql"})
    @Test
    void importAstronomersZeroTest() throws IOException, JAXBException {
        String expected = "Successfully imported mountaineer John Doe\n" +
                "Successfully imported mountaineer Jane Smith\n" +
                "Successfully imported mountaineer Michael Johnson\n" +
                "Invalid mountaineer\n" +
                "Successfully imported mountaineer Emily Brown\n" +
                "Successfully imported mountaineer Daniel Martinez\n" +
                "Successfully imported mountaineer Sarah Taylor\n" +
                "Successfully imported mountaineer Matthew Anderson\n" +
                "Successfully imported mountaineer Jessica Wilson\n" +
                "Successfully imported mountaineer Christopher Thompson\n" +
                "Successfully imported mountaineer Amanda Garcia\n" +
                "Successfully imported mountaineer David Hernandez\n" +
                "Successfully imported mountaineer Ashley Lopez\n" +
                "Successfully imported mountaineer James Gonzalez\n" +
                "Successfully imported mountaineer Jennifer Rodriguez\n" +
                "Successfully imported mountaineer Ryan Perez\n" +
                "Successfully imported mountaineer Nicole Sanchez\n" +
                "Successfully imported mountaineer Kevin Ramirez\n" +
                "Successfully imported mountaineer Elizabeth Torres\n" +
                "Successfully imported mountaineer William Flores\n" +
                "Successfully imported mountaineer Megan Rivera\n" +
                "Successfully imported mountaineer Jacob Campbell\n" +
                "Successfully imported mountaineer Olivia Carter\n" +
                "Successfully imported mountaineer Liam Hill\n" +
                "Successfully imported mountaineer Emma Yung\n" +
                "Successfully imported mountaineer Mason Green\n" +
                "Successfully imported mountaineer Sophia King\n" +
                "Successfully imported mountaineer Peter Evans\n" +
                "Successfully imported mountaineer Isabella Scott\n" +
                "Successfully imported mountaineer Ethan Adams\n" +
                "Successfully imported mountaineer Amelia Baker\n" +
                "Successfully imported mountaineer Alexander Cook\n" +
                "Successfully imported mountaineer Marta Gonzales\n" +
                "Successfully imported mountaineer Samantha Nelson\n" +
                "Successfully imported mountaineer Benjamin Mitchell\n" +
                "Successfully imported mountaineer Chloe Roberts\n" +
                "Successfully imported mountaineer Dani Leen\n" +
                "Successfully imported mountaineer Ava Walker\n" +
                "Successfully imported mountaineer Madison Hall\n" +
                "Successfully imported mountaineer Patrick Lewis\n" +
                "Successfully imported mountaineer Abigail Young\n";

        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        String actual = mountaineerService.importMountaineers();
        String[] actualSplit = actual.split("\\r\\n?|\\n");


        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }
}

