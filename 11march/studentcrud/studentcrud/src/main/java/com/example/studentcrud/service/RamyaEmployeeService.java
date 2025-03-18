package com.example.studentcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcrud.model.Employee;

import com.example.studentcrud.repository.RamyaEmployeeRepository;


@Service


public class RamyaEmployeeService {

@Autowired
    private  RamyaEmployeeRepository employeeRepository;

    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    

    
}

    public void saveemployee(Employee emp) {
        
        throw new UnsupportedOperationException("Unimplemented method 'saveemployee'");
    }

    public void deleteemployee(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deleteemployee'");
    }

    public Object getemployee(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getemployee'");
    }
}