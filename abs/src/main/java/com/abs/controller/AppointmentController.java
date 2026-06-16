package com.abs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abs.entity.Appointment;
import com.abs.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return service.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Optional<Appointment> getAppointmentById(
            @PathVariable Integer id) {

        return service.getAppointmentById(id);
    }

    @PostMapping
    public Appointment createAppointment(
            @RequestBody Appointment appointment) {

        return service.createAppointment(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(
            @PathVariable Integer id,
            @RequestBody Appointment appointment) {

        return service.updateAppointment(id, appointment);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(
            @PathVariable Integer id) {

        service.deleteAppointment(id);
        return "Appointment Deleted Successfully";
    }
}