package com.example.cmp.Controller;

import com.example.cmp.Model.ResedentialProject;
import com.example.cmp.Service.ResedentialProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects/resedential")
public class ResedentialProjectController {

    @Autowired
    private ResedentialProjectService resedentialService;

    // Display all resedential entries
    @GetMapping
    public String getAllResedentials(Model model) {
        model.addAttribute("resedentialList", resedentialService.getAllResedentials());
        model.addAttribute("newResedential", new ResedentialProject()); // For form binding
        return "resedential"; // corresponds to resedential.html
    }

}
