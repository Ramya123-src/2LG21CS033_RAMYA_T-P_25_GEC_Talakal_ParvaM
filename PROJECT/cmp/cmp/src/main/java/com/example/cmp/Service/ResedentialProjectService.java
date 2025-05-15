package com.example.cmp.Service;

import com.example.cmp.Model.ResedentialProject;
import com.example.cmp.Repository.ResedentialProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResedentialProjectService {

    private final ResedentialProjectRepository resedentialRepository;

    @Autowired
    public ResedentialProjectService(ResedentialProjectRepository resedentialRepository) {
        this.resedentialRepository = resedentialRepository;
    }

    // Get all resedential records
    public List<ResedentialProject> getAllResedentials() {
        return resedentialRepository.findAll();
    }

    // Get a resedential record by ID
    public ResedentialProject getResedentialById(Long id) {
        Optional<ResedentialProject> optional = resedentialRepository.findById(id);
        return optional.orElse(null);
    }

    // Save or update a resedential record
    public void saveResedential(ResedentialProject resedential) {
        resedentialRepository.save(resedential);
    }

    // Delete a resedential record by ID (hard delete)
    public void deleteResedential(Long id) {
        resedentialRepository.deleteById(id);
    }

    // Optional: soft delete
    public void softDeleteResedential(Long id) {
        Optional<ResedentialProject> optional = resedentialRepository.findById(id);
        if (optional.isPresent()) {
            ResedentialProject resedential = optional.get();
            resedential.setDelete_status("deleted"); // Ensure field exists in the model
            resedentialRepository.save(resedential);
        }
    }
}
