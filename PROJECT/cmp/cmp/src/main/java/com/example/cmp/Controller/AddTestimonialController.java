package com.example.cmp.Controller;

import com.example.cmp.Model.Testimonial;
import com.example.cmp.Service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/testimonials")
public class AddTestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    // Show Add Testimonial Form + List Existing Testimonials
    @GetMapping("/add")
    public String showAddTestimonialForm(Model model) {
        model.addAttribute("testimonial", new Testimonial()); // Empty form object
        model.addAttribute("testimonialList", testimonialService.getAllTestimonials()); // Display all testimonials
        return "addtestimonial"; // View template: addtestimonial.html
    }

    // Handle Add Testimonial Form Submission
    @PostMapping("/add")
    public String addTestimonial(@ModelAttribute("testimonial") Testimonial testimonial) {
        testimonialService.saveTestimonial(testimonial);
        return "redirect:/testimonials/add"; // Reload form + list
    }
}
