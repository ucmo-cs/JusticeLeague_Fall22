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

    @PatchMapping("/appointment/{appointmentID}")
    public ResponseEntity<?> editAppointment(@PathVariable Long appointmentID, @RequestBody Appointment appointment){
        return new ResponseEntity<>(appServ.edit(appointmentID, appointment), HttpStatus.OK);
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

    /*
        - Function: findAppointment
        - Purpose: used to find a single appointment
        - How: uses a GET request to find an appointment
    */
    @GetMapping("/{tempCustID}/appointment/{appointmentID}")
    public ResponseEntity<?> findAppointment(@PathVariable Long appointmentID){
        return new ResponseEntity<>(appServ.findAppointment(appointmentID), HttpStatus.OK);
    }

    /*
        - Function: deleteAppointment
        - Purpose: used to delete a single appointment
        - How: uses a DELETE request to delete an appointment
    */
    @DeleteMapping("/appointment/{appointmentID}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long appointmentID){
        return new ResponseEntity<>(appServ.deleteAppointment(appointmentID), HttpStatus.OK);
    }
}
