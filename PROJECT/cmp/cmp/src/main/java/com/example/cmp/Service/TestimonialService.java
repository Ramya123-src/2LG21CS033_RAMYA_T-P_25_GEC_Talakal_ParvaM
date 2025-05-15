package com.example.cmp.Service;

import com.example.cmp.Model.Testimonial;
import com.example.cmp.Repository.TestimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonialService {

    private final TestimonialRepository testimonialRepository;

    @Autowired
    public TestimonialService(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    // Get all testimonials
    public List<Testimonial> getAllTestimonials() {
        return testimonialRepository.findAll();
    }

    // Get testimonial by ID (returns Optional if needed for further processing)
    public Testimonial getTestimonialById(Long id) {
        return testimonialRepository.findById(id).orElse(null); // or handle differently as needed
    }

    // Save or update testimonial (this method handles both saving and updating)
    public void saveTestimonial(Testimonial testimonial) {
        testimonialRepository.save(testimonial); // Reusing save for both save and update
    }

    // Delete testimonial by ID (permanent delete)
    public void deleteTestimonial(Long id) {
        testimonialRepository.deleteById(id);
    }
}
