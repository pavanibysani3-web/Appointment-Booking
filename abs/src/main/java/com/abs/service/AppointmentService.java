package com.abs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abs.entity.Appointment;
import com.abs.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }

    public Optional<Appointment> getAppointmentById(Integer id) {
        return repo.findById(id);
    }

    public Appointment createAppointment(Appointment appointment) {

        boolean slotExists =
                repo.existsByDoctorIdAndAppointmentDateAndAppointmentTime(
                        appointment.getDoctorId(),
                        appointment.getAppointmentDate(),
                        appointment.getAppointmentTime()
                );

        if(slotExists) {
            throw new RuntimeException(
                    "This doctor already has an appointment at this time."
            );
        }

        return repo.save(appointment);
    }

    public Appointment updateAppointment(Integer id,
                                         Appointment appointment) {

        appointment.setId(id);
        return repo.save(appointment);
    }

    public void deleteAppointment(Integer id) {
        repo.deleteById(id);
    }
}