package softuni.exam.readFile;
//TestMountainServiceReadFileContent

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.service.impl.MountainServiceImpl;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class TestMountainServiceReadFileContent {

    @InjectMocks
    private MountainServiceImpl volcanoService;

    @Test
    void readMountainsFileContent() throws IOException {
        String expected = "[\n" +
                "  {\n" +
                "    \"name\": \"Mount Vesuvius\",\n" +
                "    \"elevation\": 1281,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Vesuvius\",\n" +
                "    \"elevation\": 1281,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mauna Loa\",\n" +
                "    \"elevation\": 4169,\n" +
                "    \"elevationCategory\": \"HIGH\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 2\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Fuji\",\n" +
                "    \"elevation\": 3776,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": false,\n" +
                "    \"country\": 3\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount St. Helens\",\n" +
                "    \"elevation\": 2549,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": false,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Kilimanjaro\",\n" +
                "    \"elevation\": 5895,\n" +
                "    \"elevationCategory\": \"HIGH\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 9\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Klyuchevskaya Sopka\",\n" +
                "    \"elevation\": 4754,\n" +
                "    \"elevationCategory\": \"HIGH\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 8\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Popocatepetl\",\n" +
                "    \"elevation\": 5393,\n" +
                "    \"elevationCategory\": \"HIGH\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Elbrus\",\n" +
                "    \"elevation\": 5642,\n" +
                "    \"elevationCategory\": \"HIGH\",\n" +
                "    \"hardToReach\": false,\n" +
                "    \"country\": 5\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Eyjafjallajokull\",\n" +
                "    \"elevation\": 1666,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 7\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Erebus\",\n" +
                "    \"elevation\": 3794,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 10\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Rainier\",\n" +
                "    \"elevation\": 4392,\n" +
                "    \"elevationCategory\": \"HIGH\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Piton de la Fournaise\",\n" +
                "    \"elevation\": 2632,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Etna\",\n" +
                "    \"elevation\": 3357,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Shasta\",\n" +
                "    \"elevation\": 4322,\n" +
                "    \"elevationCategory\": \"HIGH\",\n" +
                "    \"hardToReach\": false,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Ijen\",\n" +
                "    \"elevation\": 2799,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Rinjani\",\n" +
                "    \"elevation\": 3726,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Merapi\",\n" +
                "    \"elevation\": 2884,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Tambora\",\n" +
                "    \"elevation\": 2850,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Pelee\",\n" +
                "    \"elevation\": 1397,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 14\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Pacaya\",\n" +
                "    \"elevation\": 2552,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Novarupta\",\n" +
                "    \"elevation\": 841,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Cotopaxi\",\n" +
                "    \"elevation\": 5897,\n" +
                "    \"elevationCategory\": \"HIGH\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 13\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Cleveland\",\n" +
                "    \"elevation\": 1730,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Santa Maria\",\n" +
                "    \"elevation\": 3772,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 12\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Aniakchak\",\n" +
                "    \"elevation\": 1290,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Paricutin\",\n" +
                "    \"elevation\": 2800,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": false,\n" +
                "    \"country\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Jefferson\",\n" +
                "    \"elevation\": 3199,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Wizard Island\",\n" +
                "    \"elevation\": 2300,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Tehama\",\n" +
                "    \"elevation\": 3367,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": false,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Scott\",\n" +
                "    \"elevation\": 2758,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": false,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mono-Inyo Craters\",\n" +
                "    \"elevation\": 2692,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Black Butte\",\n" +
                "    \"elevation\": 1945,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Lassen Peak\",\n" +
                "    \"elevation\": 3187,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": false,\n" +
                "    \"country\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Stromboli\",\n" +
                "    \"elevation\": 924,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Sinabung\",\n" +
                "    \"elevation\": 2460,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Semeru\",\n" +
                "    \"elevation\": 3676,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Agung\",\n" +
                "    \"elevation\": 3031,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Krakatoa\",\n" +
                "    \"elevation\": 813,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Kelud\",\n" +
                "    \"elevation\": 1731,\n" +
                "    \"elevationCategory\": \"LOW\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 11\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Mount Bromo\",\n" +
                "    \"elevation\": 2329,\n" +
                "    \"elevationCategory\": \"MEDIUM\",\n" +
                "    \"hardToReach\": true,\n" +
                "    \"country\": 11\n" +
                "  }\n" +
                "]";

        String actual = volcanoService.readMountainsFileContent()
                .replaceAll("\\r\\n|\\r|\\n", "\n").trim();

        Assertions.assertEquals(expected, actual);
    }
}