package com.example.cmp.Controller;

import com.example.cmp.Model.Services;
import com.example.cmp.Service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/services")
public class AddServiceController {

    @Autowired
    private ServicesService servicesService;

    // Show Add Service Form + List Existing Services
    @GetMapping("/add")
    public String showAddServiceForm(Model model) {
        model.addAttribute("service", new Services()); // Empty form object
        model.addAttribute("serviceList", servicesService.getAllServices()); // Display all services
        return "addservice"; // View template: addservices.html
    }

    // Handle Add Service Form Submission
    @PostMapping("/add")
    public String addService(@ModelAttribute("service") Services service) {
        servicesService.saveService(service);
        return "redirect:/services/add"; // Reload form + list
    }
}
