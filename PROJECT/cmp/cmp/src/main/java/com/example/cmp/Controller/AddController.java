package com.example.cmp.Controller;

import com.example.cmp.Model.CommercialProject;
import com.example.cmp.Service.CommercialProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class AddController {

    @Autowired
    private CommercialProjectService commercialService;

    // Show Add Form + Existing Projects (GET)
    @GetMapping("/add")
    public String showAddProjectForm(Model model) {
        model.addAttribute("commercial", new CommercialProject()); // Empty form model
        model.addAttribute("commercialList", commercialService.getAllCommercials()); // Existing projects
        return "add"; // maps to templates/add.html
    }

    // Handle Form Submission (POST)
    @PostMapping("/add")
    public String addProject(@ModelAttribute("commercial") CommercialProject commercial) {
        commercialService.saveCommercial(commercial);
        return "redirect:/projects/add"; // Refresh same form + project list
    }
}
