package com.example.cmp.Repository;

import com.example.cmp.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // You can define custom queries here if needed, for example:
    // Optional<Admin> findByUsername(String username);
}
