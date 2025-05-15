package com.example.cmp.Controller;

import com.example.cmp.Service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping()
    public String getServiceById(Model model) {

        model.addAttribute("services", servicesService.getAllServices());
        // System.out.print("Im here ");
        // System.out.print(servicesService.getAllServices());
        return "service"; // This corresponds to service.html or service-detail.html
    }
}
