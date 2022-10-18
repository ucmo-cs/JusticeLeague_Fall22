package com.example.Gilgamesh.Commerce.Project.controller;

import com.example.Gilgamesh.Commerce.Project.service.AppointmentService;
import com.example.Gilgamesh.Commerce.Project.domain.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class AppointmentController {
    private final AppointmentService appServ;

    long tempCustID = 1;

    /*
        - Function: createAppointment
        - Purpose: used to create an instance of an appointment
        - How: uses a POST request with parameters appointment type, location, and time
            to create a server side instance of an appointment
    */
    @PostMapping("/appointment")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment){

        return new ResponseEntity<>(appServ.create(tempCustID, appointment), HttpStatus.CREATED);
    }

    @PatchMapping("/appointment={appointmentID}")
    public ResponseEntity<?> editAppointment(@RequestBody Appointment appointment){
        return new ResponseEntity<>(appServ.edit(appointment.getId(), appointment), HttpStatus.OK);
    }

    /*
        - Function: findAllAppointments
        - Purpose: used to find all appointments for a certain user
        - How: uses a GET request to find all appointments for a specific user @ a specific customerID
    */
    @GetMapping("/{tempCustID}/appointment")
    public ResponseEntity<?> findAllAppointments(){
        return new ResponseEntity<>(appServ.findAllAppointments(), HttpStatus.OK);
    }
}
