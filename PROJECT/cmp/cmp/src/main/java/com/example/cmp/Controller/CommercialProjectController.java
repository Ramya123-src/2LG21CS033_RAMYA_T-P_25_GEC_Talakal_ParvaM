package com.example.cmp.Controller;

import com.example.cmp.Model.CommercialProject;
import com.example.cmp.Service.CommercialProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects/commercial")
public class CommercialProjectController {

    private final CommercialProjectService commercialService;

    @Autowired
    public CommercialProjectController(CommercialProjectService commercialService) {
        this.commercialService = commercialService;
    }

    // Display all commercial projects
    @GetMapping
    public String showCommercialProjects(Model model) {
        model.addAttribute("commercialList", commercialService.getAllCommercials());
        model.addAttribute("newCommercial", new CommercialProject()); // For add form
        return "commercial"; // Maps to src/main/resources/templates/commercial.html
    }

    // Optional: Handle saving new project

}
