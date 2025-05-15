package com.example.cmp.Controller;

import com.example.cmp.Model.Testimonial;
import com.example.cmp.Service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/testimonials")
public class EditTestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    // Show all testimonials in edit page
    @GetMapping("/edit")
    public String showEditTestimonials(Model model) {
        model.addAttribute("testimonials", testimonialService.getAllTestimonials());
        return "edittestimonial"; // points to templates/edit.html
    }

    // Update testimonial (POST from form)
    @PostMapping("/update")
    public String updateTestimonial(@RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("content") String content,
            @RequestParam(value = "imagePath", required = false) String imagePath) {
        Testimonial existing = testimonialService.getTestimonialById(id);
        if (existing != null) {
            existing.setName(name);
            existing.setContent(content);
            existing.setImagePath(imagePath);
            testimonialService.saveTestimonial(existing);
        }
        return "redirect:/testimonials/edit";
    }

    // Delete testimonial (POST from form)
    @PostMapping("/delete")
    public String deleteTestimonial(@RequestParam("id") Long id) {
        testimonialService.deleteTestimonial(id);
        return "redirect:/testimonials/edit";
    }
}
