package com.example.cmp.Service;

import com.example.cmp.Model.Services;
import com.example.cmp.Repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring-managed service bean
public class ServicesService {

    private ServicesRepository servicesRepository;

    // Constructor-based dependency injection
    @Autowired
    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    // Get all services
    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    // Get service by ID
    public Services getServiceById(Long id) {
        Optional<Services> optional = servicesRepository.findById(id);
        return optional.orElse(null);
    }

    // Save or update a service
    public void saveService(Services service) {
        servicesRepository.save(service);
    }

    // Delete a service by ID (hard delete)
    public void deleteService(Long id) {
        servicesRepository.deleteById(id);
    }

    // Optional: soft delete by setting delete_status
    public void softDeleteService(Long id) {
        Optional<Services> optional = servicesRepository.findById(id);
        if (optional.isPresent()) {
            Services service = optional.get();
            service.setDelete_status("deleted");
            servicesRepository.save(service);
        }
    }
}
