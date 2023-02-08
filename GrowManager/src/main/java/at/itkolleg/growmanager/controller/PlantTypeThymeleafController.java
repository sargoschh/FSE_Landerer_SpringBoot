package at.itkolleg.growmanager.controller;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.services.PlantTypeService;
import at.itkolleg.growmanager.services.PlantTypeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/growmanager/v1/plantTypes")
public class PlantTypeThymeleafController {

    private PlantTypeService plantTypeService;

    public PlantTypeThymeleafController(PlantTypeService plantTypeService) {
        this.plantTypeService = plantTypeService;
    }

    @GetMapping
    public String getAllPlantTypes(Model model) {
        model.addAttribute("allPlantTypes", this.plantTypeService.allPlantTypes());
        return "allPlantTypes";
    }

    @GetMapping("/insert")
    public String insertPlantTypeForm(Model model) {
        PlantType plantType = new PlantType();
        model.addAttribute("plantType", plantType);
        return "insertPlantType";
    }
}
