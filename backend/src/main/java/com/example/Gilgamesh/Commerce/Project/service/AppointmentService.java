package com.example.Gilgamesh.Commerce.Project.service;

import com.example.Gilgamesh.Commerce.Project.domain.Appointment;
import com.example.Gilgamesh.Commerce.Project.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Transactional
    public Appointment create(Long cus_id, Appointment appointment){

        System.out.println("type: " + appointment.getAppointmentType());
        System.out.println("location: " + appointment.getLocation());
        System.out.println("time: " + appointment.getTime());

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment edit(Long appointment_id, Appointment newApp)
    {
        Appointment original = appointmentRepository.findById(appointment_id).get();

        // using this to try and guard from errors
        if (original != null) {
            original.setAppointmentType((newApp.getAppointmentType() != null) ? newApp.getAppointmentType() : original.getAppointmentType());
            original.setLocation((newApp.getLocation() != null) ? newApp.getLocation() : original.getLocation());
            original.setTime((newApp.getTime() != null) ? newApp.getTime() : original.getTime());
        }
        return original;
    }

    @Transactional(readOnly = true)
    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Appointment findAppointment(Long appId) { return appointmentRepository.findById(appId).get(); }

    @Transactional
    public String deleteAppointment(Long appId) {
        appointmentRepository.deleteById(appId);
        return "ok - appointment deleted";
    }
}
