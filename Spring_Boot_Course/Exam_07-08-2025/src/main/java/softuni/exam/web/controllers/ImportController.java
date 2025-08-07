package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.CountryService;
import softuni.exam.service.MountainService;
import softuni.exam.service.MountaineerService;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

    private final MountainService mountainService;
    private final MountaineerService mountaineerService;
    private final CountryService countryService;

    @Autowired
    public ImportController(MountainService mountainService, MountaineerService mountaineerService, CountryService countryService) {
        this.mountainService = mountainService;
        this.mountaineerService = mountaineerService;
        this.countryService = countryService;
    }


    @GetMapping("/json")
    public ModelAndView importJson() {

        boolean[] areImported = new boolean[]{
                this.countryService.areImported(),
                this.mountainService.areImported()
        };

        return super.view("json/import-json", "areImported", areImported);
    }


    @GetMapping("/xml")
    public ModelAndView importXml() {
        boolean[] areImported = new boolean[]{
                this.mountaineerService.areImported()
        };

        return super.view("xml/import-xml", "areImported", areImported);
    }



    @GetMapping("/countries")
    public ModelAndView importCountries() throws IOException {
        String fileContent = this.countryService.readCountriesFromFile();

        return super.view("json/import-countries", "countries", fileContent);
    }

    @PostMapping("/countries")
    public ModelAndView importConstellationsConfirm() throws IOException {
        System.out.println(this.countryService.importCountries());
        return super.redirect("/import/json");
    }

    @GetMapping("/mountains")
    public ModelAndView importMountains() throws IOException {
        String fileContent = this.mountainService.readMountainsFileContent();

        return super.view("json/import-mountains", "mountains", fileContent);
    }

    @PostMapping("/mountains")
    public ModelAndView importMountainsConfirm() throws IOException, JAXBException {
        System.out.println(this.mountainService.importMountains());
        return super.redirect("/import/json");
    }


    @GetMapping("/mountaineers")
    public ModelAndView importMountaineers() throws IOException {
        String mountaineersXmlFileContent = this.mountaineerService.readMountaineersFromFile();

        return super.view("xml/import-mountaineers", "mountaineers", mountaineersXmlFileContent);
    }

    @PostMapping("/mountaineers")
    public ModelAndView importMountaineersConfirm() throws JAXBException, IOException {
        System.out.println(this.mountaineerService.importMountaineers());

        // return super.redirect("/import/xml");
        return super.redirect("/");
    }
}
