package softuni.exam.import_Mountains;
//TestImportMountainElevationCountOfDigits003

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.MountainService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestImportMountainElevationCountOfDigits003 {

    @Autowired
    private MountainService mountainService;

    @Test
    @Sql("/countries-test-imports.sql")
    void   importMountains() throws IOException {

        String expected = "Successfully imported mountain Mount Vesuvius\n" +
                "Invalid mountain";
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        copyRewriteFileForTest();
        String actual = mountainService.importMountains();
        String[] actualSplit = actual.split("\\r\\n?|\\n");

        returnOriginalValue();
        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }


    private void copyRewriteFileForTest() {
        File originalJsonFile = getOriginalFile();

        String testJSON = "[\n" +
                "  {\n" +
                "    \"name\": \"Mount Vesuvius\",\n" +
                "    \"elevation\": 1281,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": \"true\",\n" +
                "    \"country\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount\",\n" +
                "    \"elevation\": 12812,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": \"true\",\n" +
                "    \"country\": 1\n" +
                "  }\n" +
                "]";

        try {
            FileWriter f2 = new FileWriter(originalJsonFile, false);
            f2.write(testJSON);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getOriginalFile() {
        return new File("src/main/resources/files/json/mountains.json");
    }

    private void returnOriginalValue() {

        try {
            FileWriter f2 = new FileWriter(getOriginalFile(), false);
            String testOriginalFile = Files.readString(Path.of("src/test/resources/original-files/mountains.json"));
            f2.write(testOriginalFile);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
