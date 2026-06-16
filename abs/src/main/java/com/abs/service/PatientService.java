package com.abs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abs.entity.Patient;
import com.abs.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public List<Patient> getAllPatients() {
        return repo.findAll();
    }

    public Optional<Patient> getPatientById(Integer id) {
        return repo.findById(id);
    }

    public Patient createPatient(Patient patient) {
        return repo.save(patient);
    }

    public Patient updatePatient(Integer id, Patient patient) {
        patient.setId(id);
        return repo.save(patient);
    }

    public void deletePatient(Integer id) {
        repo.deleteById(id);
    }
}