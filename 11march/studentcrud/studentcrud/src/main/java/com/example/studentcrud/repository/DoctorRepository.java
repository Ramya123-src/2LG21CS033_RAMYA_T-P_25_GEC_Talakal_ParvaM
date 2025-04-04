package com.example.studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.studentcrud.model.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>  {
}
