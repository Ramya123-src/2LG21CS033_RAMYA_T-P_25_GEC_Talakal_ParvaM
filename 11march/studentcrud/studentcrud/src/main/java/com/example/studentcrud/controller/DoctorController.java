package com.example.studentcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.studentcrud.model.Doctor;
import com.example.studentcrud.service.DoctorService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/savers")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("doctor",doctorService.listAll() );
        return "doctor/index"; 
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/create";
    }

    @PostMapping("/save")
    public String saveDoctor(@ModelAttribute Doctor stu) {
        doctorService.saveDoctor(stu);
        return "redirect:/savers/list";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/savers/list";
    }
    @GetMapping("/edit/{id}")
    public String editDoctor(@PathVariable Long id,Model model) {
        model .addAttribute("doctor",doctorService.getDoctor(id));
        return "doctor/edit";
    }
   
    @PostMapping("/update/{id}")
    public String saveDoctor(@Pathvariable Long id, 
        @ModelAttribute Doctor stu) {
           stu.setId(id);
           doctorService.saveDoctor(stu);
           return "redirect:/savers/list"; 
        }
    }
    
