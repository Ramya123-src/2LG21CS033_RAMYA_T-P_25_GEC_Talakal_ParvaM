package com.example.cmp.Service;

import com.example.cmp.Model.CommercialProject;
import com.example.cmp.Repository.CommercialProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommercialProjectService {

    private final CommercialProjectRepository commercialRepository;

    @Autowired
    public CommercialProjectService(CommercialProjectRepository commercialRepository) {
        this.commercialRepository = commercialRepository;
    }

    // Get all commercial projects
    public List<CommercialProject> getAllProjects() {
        return commercialRepository.findAll();
    }

    // Alias method for controller compatibility
    public List<CommercialProject> getAllCommercials() {
        return getAllProjects();
    }

    // Get a commercial project by ID
    public CommercialProject getCommercialById(Long id) {
        return commercialRepository.findById(id).orElse(null);
    }

    // Save or update a commercial project
    public void saveCommercial(CommercialProject commercial) {
        if (commercial.getDelete_status() == null) {
            commercial.setDelete_status("active"); // Default to active if not provided
        }
        commercialRepository.save(commercial);
    }

    // Update an existing project
    public void updateProject(CommercialProject project) {
        saveCommercial(project); // Just reuse save logic
    }

    // Delete permanently (used by controller)
    public void deleteProject(Long id) {
        commercialRepository.deleteById(id);
    }

    // Soft delete (optional, not used in controller currently)
    public void softDeleteCommercial(Long id) {
        Optional<CommercialProject> optional = commercialRepository.findById(id);
        if (optional.isPresent()) {
            CommercialProject commercial = optional.get();
            commercial.setDelete_status("deleted");
            commercialRepository.save(commercial);
        }
    }
}
