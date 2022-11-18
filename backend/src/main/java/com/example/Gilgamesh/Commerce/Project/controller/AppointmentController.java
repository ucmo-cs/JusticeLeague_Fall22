package com.example.Gilgamesh.Commerce.Project.controller;

import com.example.Gilgamesh.Commerce.Project.DTO.AppointmentDTO;
import com.example.Gilgamesh.Commerce.Project.StringLibrary;
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

    /*
        - Function: createAppointment
        - Purpose: used to create an instance of an appointment
        - How: uses a POST request with parameters appointment type, location, and time
            to create a server side instance of an appointment
    */
    @PostMapping("/customer={customerID}/appointment")
    public ResponseEntity<?> createAppointment(@PathVariable Long customerID,@RequestBody AppointmentDTO appointment){

        AppointmentDTO createdAppointment = appServ.create(customerID, appointment);
        ResponseEntity<?> response = (createdAppointment == null)
                // This string library may just be temp
                ? new ResponseEntity<>(StringLibrary.InvalidTimeMessage(), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
        return response;
    }

    /*
       - Function: editAppointment
       - Purpose: used to edit an instance of an appointment
       - How: uses a PATCH request with parameters appointment type, location, and time
           to edit a server side instance of an appointment
   */
    @PatchMapping("/customer={customerID}/appointment={appointmentID}")
    public ResponseEntity<?> editAppointment(@PathVariable Long appointmentID, @RequestBody AppointmentDTO appointmentDTO){
        return new ResponseEntity<>(appServ.edit(appointmentID, appointmentDTO), HttpStatus.OK);
    }

    /*
        - Function: findAllCustomerAppointments
        - Purpose: used to find all appointments for a certain user
        - How: uses a GET request to find all appointments for a specific user @ a specific customerID
    */
    @GetMapping("/customer={customerID}/appointment")
    public ResponseEntity<?> findAllCustomerAppointments(@PathVariable Long customerID){
        return new ResponseEntity<>(appServ.findAllCustomerAppointments(customerID), HttpStatus.OK);
    }

    /*
        - Function: findAppointment
        - Purpose: used to find a single appointment
        - How: uses a GET request to find an appointment
    */
    @GetMapping("/customer={customerID}/appointment={appointmentID}")
    public ResponseEntity<?> findAppointment(@PathVariable Long appointmentID){
        return new ResponseEntity<>(appServ.findAppointment(appointmentID), HttpStatus.OK);
    }

    /*
        - Function: findEveryAppointment
        - Purpose: used to find all the appointments in the system
        - How: uses a GET request to find all appointments
    */
    @GetMapping("/appointment")
    public ResponseEntity<?> findEveryAppointment() {
        return new ResponseEntity<>(appServ.findEveryAppointment(), HttpStatus.OK);
    }

    /*
        - Function: deleteAppointment
        - Purpose: used to delete a single appointment
        - How: uses a DELETE request to delete an appointment
    */
    @DeleteMapping("/appointment={appointmentID}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long appointmentID){
        return new ResponseEntity<>(appServ.deleteAppointment(appointmentID), HttpStatus.OK);
    }
}
