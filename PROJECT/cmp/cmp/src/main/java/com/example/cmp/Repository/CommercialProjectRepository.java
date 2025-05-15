package com.example.cmp.Repository;

import com.example.cmp.Model.CommercialProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialProjectRepository extends JpaRepository<CommercialProject, Long> {
    // You can define custom query methods here if needed
}
