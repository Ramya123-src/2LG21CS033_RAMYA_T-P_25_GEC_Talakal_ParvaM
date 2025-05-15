package com.example.cmp.Repository;

import com.example.cmp.Model.ResedentialProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResedentialProjectRepository extends JpaRepository<ResedentialProject, Long> {
    // You can define custom query methods here if needed
}
