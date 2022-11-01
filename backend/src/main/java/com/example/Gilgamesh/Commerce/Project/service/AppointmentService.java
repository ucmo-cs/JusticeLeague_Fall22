package com.example.Gilgamesh.Commerce.Project.service;

import com.example.Gilgamesh.Commerce.Project.domain.Appointment;
import com.example.Gilgamesh.Commerce.Project.domain.Customer;
import com.example.Gilgamesh.Commerce.Project.repository.AppointmentRepository;
import com.example.Gilgamesh.Commerce.Project.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.ZoneOffset;
import java.lang.Math;
import java.util.List;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;

    /*
        - Function: create
        - Purpose: used to create a single appointment
    */
    @Transactional
    public Appointment create(Long cus_id, Appointment appointment){
        if (!checkAppointmentAvailability(appointment)) {return null;}

        Customer customer;
        customer = customerRepository.findById(cus_id).orElseThrow(()->new IllegalArgumentException("Check customer Id"));
        appointment.setCustomer(customer);
        return appointmentRepository.save(appointment);
    }

    /*
        - Function: edit
        - Purpose: used to edit a single appointment
    */
    @Transactional
    public Appointment edit(Long appointment_id, Appointment newApp)
    {
        Appointment original = appointmentRepository.findById(appointment_id).get();

        if(original != null)
        {
            original.setAppointmentType((newApp.getAppointmentType() != null) ? newApp.getAppointmentType() : original.getAppointmentType());

            if(!original.getLocation().equals(newApp.getLocation()) || !original.getTime().equals(newApp.getTime()))
            {
                if (checkAppointmentAvailability(newApp))
                {
                    original.setLocation((newApp.getLocation() != null) ? newApp.getLocation() : original.getLocation());
                    original.setTime((newApp.getTime() != null) ? newApp.getTime() : original.getTime());
                }
            }
        }

        return original;
    }

    /*
        - Function: findAllAppointments
        - Purpose: used to find all appointments
    */
    @Transactional(readOnly = true)
    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    /*
        - Function: findAppointment
        - Purpose: used to find a single appointment
    */
    @Transactional(readOnly = true)
    public Appointment findAppointment(Long appId) { return appointmentRepository.findById(appId).orElseThrow(() -> new IllegalArgumentException("Check appointment ID")); }

    /*
        - Function: deleteAppointment
        - Purpose: used to delete a single appointment
    */
    @Transactional
    public String deleteAppointment(Long appId) {
        appointmentRepository.deleteById(appId);
        return "ok - appointment deleted";
    }

    /*
        - Function: checkAppointmentAvailability
        - Purpose: checks to see if an appointment is scheduled in an already blocked out hour of time
            for a given location and prevents things from being scheduled then.
    */
    private Boolean checkAppointmentAvailability(Appointment appointment)
    {
        // list of all the stored appointments
        List<Appointment> appointmentList = appointmentRepository.findAll();

        // Compares the appointment trying to be edited/created to the ones in the Database
        for(Appointment a : appointmentList)
        {
            if(appointment.getLocation().equals(a.getLocation()))
            {
                double timeDiff = Math.abs (((appointment.getTime().toEpochSecond(ZoneOffset.UTC)
                        - a.getTime().toEpochSecond(ZoneOffset.UTC)) / 60.0) / 60.0);

                if (timeDiff >= 0 && timeDiff < 1) { return false; }
            }
        }
        return true;
    }
}
