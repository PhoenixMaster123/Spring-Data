package softuni.exam.export;
//TestMountainServiceExport001

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.impl.MountainServiceImpl;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestMountainServiceExport001 {

    @Autowired
    private MountainServiceImpl volcanoService;

    @Sql("/export-test-001.sql")
    @Test
    void exportVolcano001() {
        String actual = volcanoService.exportMountains();

        String expected = """
                Mountain: Cotopaxi
                   *Located in: Ecuador
                   **Elevation: 5897
                Mountain: Mount Kilimanjaro
                   *Located in: Tanzania
                   **Elevation: 5895
                Mountain: Popocatepetl
                   *Located in: Mexico
                   **Elevation: 5393
                Mountain: Klyuchevskaya Sopka
                   *Located in: Russia
                   **Elevation: 4754
                Mountain: Mount Rainier
                   *Located in: USA
                   **Elevation: 4392
                Mountain: Mauna Loa
                   *Located in: Hawaii
                   **Elevation: 4169
                Mountain: Mount Erebus
                   *Located in: Ross Island
                   **Elevation: 3794
                Mountain: Santa Maria
                   *Located in: Guatemala
                   **Elevation: 3772
                Mountain: Mount Rinjani
                   *Located in: Indonesia
                   **Elevation: 3726
                Mountain: Mount Semeru
                   *Located in: Indonesia
                   **Elevation: 3676
                Mountain: Mount Etna
                   *Located in: Italy
                   **Elevation: 3357
                Mountain: Mount Jefferson
                   *Located in: USA
                   **Elevation: 3199
                Mountain: Mount Agung
                   *Located in: Indonesia
                   **Elevation: 3031""";

        String[] actualSplit = actual.split("\\r\\n?|\\n");
        String[] expectedSplit = expected.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit,actualSplit);
    }
}
