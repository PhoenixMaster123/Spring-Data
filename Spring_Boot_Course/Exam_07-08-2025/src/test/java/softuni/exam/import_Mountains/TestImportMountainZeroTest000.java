package softuni.exam.import_Mountains;
//TestImportMountainZeroTest000

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import softuni.exam.service.impl.MountainServiceImpl;

import java.io.IOException;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class TestImportMountainZeroTest000 {

    @Autowired
    private MountainServiceImpl mountainService;

    @Test
    @Sql("/countries-test-imports.sql")
    void importMountainZeroTest() throws IOException {

        String expected = "Successfully imported mountain Mount Vesuvius\n" +
                "Invalid mountain\n" +
                "Successfully imported mountain Mauna Loa\n" +
                "Successfully imported mountain Mount Fuji\n" +
                "Successfully imported mountain Mount St. Helens\n" +
                "Successfully imported mountain Mount Kilimanjaro\n" +
                "Successfully imported mountain Klyuchevskaya Sopka\n" +
                "Successfully imported mountain Popocatepetl\n" +
                "Successfully imported mountain Mount Elbrus\n" +
                "Successfully imported mountain Eyjafjallajokull\n" +
                "Successfully imported mountain Mount Erebus\n" +
                "Successfully imported mountain Mount Rainier\n" +
                "Successfully imported mountain Piton de la Fournaise\n" +
                "Successfully imported mountain Mount Etna\n" +
                "Successfully imported mountain Mount Shasta\n" +
                "Successfully imported mountain Mount Ijen\n" +
                "Successfully imported mountain Mount Rinjani\n" +
                "Successfully imported mountain Mount Merapi\n" +
                "Successfully imported mountain Mount Tambora\n" +
                "Successfully imported mountain Mount Pelee\n" +
                "Successfully imported mountain Pacaya\n" +
                "Successfully imported mountain Novarupta\n" +
                "Successfully imported mountain Cotopaxi\n" +
                "Successfully imported mountain Mount Cleveland\n" +
                "Successfully imported mountain Santa Maria\n" +
                "Successfully imported mountain Mount Aniakchak\n" +
                "Successfully imported mountain Paricutin\n" +
                "Successfully imported mountain Mount Jefferson\n" +
                "Successfully imported mountain Wizard Island\n" +
                "Successfully imported mountain Mount Tehama\n" +
                "Successfully imported mountain Mount Scott\n" +
                "Successfully imported mountain Mono-Inyo Craters\n" +
                "Successfully imported mountain Black Butte\n" +
                "Successfully imported mountain Lassen Peak\n" +
                "Successfully imported mountain Stromboli\n" +
                "Successfully imported mountain Mount Sinabung\n" +
                "Successfully imported mountain Mount Semeru\n" +
                "Successfully imported mountain Mount Agung\n" +
                "Successfully imported mountain Krakatoa\n" +
                "Successfully imported mountain Mount Kelud\n" +
                "Successfully imported mountain Mount Bromo";

        String[] expectedSplit = expected.split("\\r\\n?|\\n");
        String actual = mountainService.importMountains();
        String[] actualSplit = actual.split("\\r\\n?|\\n");

        Assertions.assertArrayEquals(expectedSplit, actualSplit);
    }


}
