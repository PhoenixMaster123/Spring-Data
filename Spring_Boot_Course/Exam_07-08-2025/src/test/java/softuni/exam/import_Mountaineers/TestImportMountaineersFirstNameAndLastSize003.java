package softuni.exam.import_Mountaineers;
//TestImportMountaineersFirstAndLastNameSize003

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import jakarta.xml.bind.JAXBException;
import softuni.exam.service.impl.MountaineerServiceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestImportMountaineersFirstNameAndLastSize003 {

    @Autowired
    private MountaineerServiceImpl mountaineerService;


    @Sql({"/countries-test-imports.sql", "/mountains-test-imports.sql"})
    @Test
    void importMountaineersValidateFirstAndLastNameSize003() throws IOException, JAXBException {

        rewriteFileForTest();
        String actual = mountaineerService.importMountaineers();
        String[] actualSplit = actual.split("\\r\\n?|\\n");

        String expected = "Successfully imported mountaineer John Doe\n" +
                "Invalid mountaineer\n" +
                "Successfully imported mountaineer Stamat Stamatov\n" +
                "Invalid mountaineer\n";

        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        returnOriginalValue();
        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }
    private void rewriteFileForTest() {
        File originalJsonFile = getOriginalFile();

        String testXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<mountaineers>\n" +
                "    <mountaineer>\n" +
                "        <first_name>John</first_name>\n" +
                "        <last_name>Doe</last_name>\n" +
                "        <budget>5000.00</budget>\n" +
                "        <age>55</age>\n" +
                "        <mountaineer_from>1987-01-15</mountaineer_from>\n" +
                "        <climbing_mountain_id>11</climbing_mountain_id>\n" +
                "    </mountaineer>\n" +
                "    <mountaineer>\n" +
                "        <first_name>J</first_name>\n" +
                "        <last_name>Efremov</last_name>\n" +
                "        <budget>5000.00</budget>\n" +
                "        <age>55</age>\n" +
                "        <mountaineer_from>1987-01-15</mountaineer_from>\n" +
                "        <climbing_mountain_id>111</climbing_mountain_id>\n" +
                "    </mountaineer>\n" +
                "    <mountaineer>\n" +
                "        <first_name>Stamat</first_name>\n" +
                "        <last_name>Stamatov</last_name>\n" +
                "        <budget>5000.00</budget>\n" +
                "        <age>55</age>\n" +
                "        <mountaineer_from>1987-01-15</mountaineer_from>\n" +
                "        <climbing_mountain_id>11</climbing_mountain_id>\n" +
                "    </mountaineer>\n" +
                "    <mountaineer>\n" +
                "        <first_name>Stamat</first_name>\n" +
                "        <last_name>E</last_name>\n" +
                "        <budget>5000.00</budget>\n" +
                "        <age>55</age>\n" +
                "        <mountaineer_from>1987-01-15</mountaineer_from>\n" +
                "        <climbing_mountain_id>111</climbing_mountain_id>\n" +
                "    </mountaineer>\n" +
                "</mountaineers>\n";

        try {
            FileWriter f2 = new FileWriter(originalJsonFile, false);
            f2.write(testXML);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getOriginalFile() {
        return new File("src/main/resources/files/xml/mountaineers.xml");
    }

    private void returnOriginalValue() {

        try {
            FileWriter f2 = new FileWriter(getOriginalFile(), false);
            String testOriginalFile = Files.readString(Path.of("src/test/resources/original-files/mountaineers.xml"));
            f2.write(testOriginalFile);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
