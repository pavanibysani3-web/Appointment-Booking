package com.abs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abs.entity.Doctor;
import com.abs.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repo;

    // Get All Doctors
    public List<Doctor> getAllDoctors() {
        return repo.findAll();
    }

    // Get Doctor By ID
    public Optional<Doctor> getDoctorById(Integer id) {
        return repo.findById(id);
    }

    // Create Doctor
    public Doctor createDoctor(Doctor doctor) {
        return repo.save(doctor);
    }

    // Update Doctor
    public Doctor updateDoctor(Integer id, Doctor doctor) {
        doctor.setId(id);
        return repo.save(doctor);
    }

    // Delete Doctor
    public void deleteDoctor(Integer id) {
        repo.deleteById(id);
    }
}