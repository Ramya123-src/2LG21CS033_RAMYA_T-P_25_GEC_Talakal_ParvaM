package com.example.cmp.Repository;

import com.example.cmp.Model.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
    // You can add custom query methods if needed
}
