package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.*;

@Controller
public class HomeController extends BaseController {

    private final MountainService mountainService;
    private final MountaineerService mountaineerService;
    private final CountryService countryService;

    @Autowired
    public HomeController(MountainService mountainService, MountaineerService mountaineerService, CountryService countryService) {
        this.mountainService = mountainService;
        this.mountaineerService = mountaineerService;
        this.countryService = countryService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        boolean areImported = this.mountainService.areImported() &&
                this.countryService.areImported() &&
                this.mountainService.areImported()  &&
                this.mountaineerService.areImported();

        return super.view("index", "areImported", areImported);
    }
}
