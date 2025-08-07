package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.MountainService;
import softuni.exam.service.MountaineerService;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final MountainService mountainService;

    @Autowired
    public ExportController(MountainService mountainService) {
        this.mountainService = mountainService;

    }


    @GetMapping("/mountains")
    public ModelAndView exportMountains() {
        String exportedMountains = this.mountainService.exportMountains();

        return super.view("export/export-mountains.html", "exportedMountains", exportedMountains);
    }

}
