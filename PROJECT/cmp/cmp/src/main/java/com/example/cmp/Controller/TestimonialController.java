package com.example.cmp.Controller;

import com.example.cmp.Service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/testimonial")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    @GetMapping()
    public String getAllTestimonials(Model model) {
        model.addAttribute("testimonial", testimonialService.getAllTestimonials());
        return "testimonial"; // This corresponds to testimonials.html
    }
}
