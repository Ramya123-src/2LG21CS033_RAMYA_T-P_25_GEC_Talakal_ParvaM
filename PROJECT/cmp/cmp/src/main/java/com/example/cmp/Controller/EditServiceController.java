package com.example.cmp.Controller;

import com.example.cmp.Model.Services;
import com.example.cmp.Service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/services")
public class EditServiceController {

    @Autowired
    private ServicesService servicesService;

    // Show the edit page with all services
    @GetMapping("/edit")
    public String showEditServices(Model model) {
        model.addAttribute("services", servicesService.getAllServices());
        return "editservice"; // corresponds to templates/editservice.html
    }

    // Handle service update
    @PostMapping("/update")
    public String updateService(@ModelAttribute Services service) {
        // Optional: Set modified_by or modified_on here
        servicesService.saveService(service);
        return "redirect:/services/edit";
    }

    // Handle service delete by ID
    @PostMapping("/delete")
    public String deleteService(@RequestParam("id") Long id) {
        servicesService.deleteService(id);
        return "redirect:/services/edit";
    }
}
