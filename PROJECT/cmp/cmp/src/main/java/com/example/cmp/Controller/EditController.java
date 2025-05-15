package com.example.cmp.Controller;

import com.example.cmp.Model.CommercialProject;
import com.example.cmp.Service.CommercialProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EditController {

    @Autowired
    private CommercialProjectService commercialProjectService;

    // Display all commercial projects for editing
    @GetMapping("/projects/edit")
    public String showEditProjects(Model model) {
        List<CommercialProject> commercialList = commercialProjectService.getAllProjects();
        model.addAttribute("commercialList", commercialList);
        return "edit"; // Corresponds to edit.html
    }

    // Handle project update form submission
    @PostMapping("/projects/update")
    public String updateProject(@ModelAttribute CommercialProject project) {
        commercialProjectService.updateProject(project);
        return "redirect:/projects/edit";
    }

    // Handle project deletion
    @PostMapping("/projects/delete")
    public String deleteProject(@RequestParam Long id) {
        commercialProjectService.deleteProject(id);
        return "redirect:/projects/edit";
    }

}
