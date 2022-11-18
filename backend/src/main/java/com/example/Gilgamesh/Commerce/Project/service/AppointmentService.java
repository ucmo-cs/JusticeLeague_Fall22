package com.example.Gilgamesh.Commerce.Project.service;

import com.example.Gilgamesh.Commerce.Project.DTO.AppointmentDTO;
import com.example.Gilgamesh.Commerce.Project.domain.Appointment;
import com.example.Gilgamesh.Commerce.Project.domain.Customer;
import com.example.Gilgamesh.Commerce.Project.domain.Location;
import com.example.Gilgamesh.Commerce.Project.domain.MeetingType;
import com.example.Gilgamesh.Commerce.Project.repository.AppointmentRepository;
import com.example.Gilgamesh.Commerce.Project.repository.CustomerRepository;
import com.example.Gilgamesh.Commerce.Project.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;
    private final LocationRepository locationRepository;

    private final LocationService locationService;

    /*
        - Function: create
        - Purpose: used to create a single appointment
    */
    @Transactional
    public AppointmentDTO create(Long cus_id, AppointmentDTO appointmentDTO){
        // gets the customers and locations
        Customer customer = customerRepository.findById(cus_id).orElseThrow(()->new IllegalArgumentException("Check customer Id"));
        Location appLocation = locationRepository.findById(appointmentDTO.getLocation().getId()).orElseThrow(()->new IllegalArgumentException("Check location Id"));

        // checks to see if the appointment is valid - ie no overlapping time slots at the same location
        if (!checkAppointmentAvailability(appointmentDTO.getTime(), appLocation)) { return null; }

        // creates an appointment and saves said appointment
        Appointment created = new Appointment();
        created.setAppointmentType((appointmentDTO.getAppointmentType() != null)
                ? appointmentDTO.getAppointmentType()
                : MeetingType.Other);
        created.setTime((appointmentDTO.getTime() != null) ? appointmentDTO.getTime() : LocalDateTime.MIN);
        created.setCustomer(customer);
        created.setLocation(appLocation);
        appointmentRepository.save(created);

        // sets the output DTO for the response
        appointmentDTO.setAppointmentId(created.getId());
        appointmentDTO.setLocation(locationService.createResponseDTO(appLocation));

        return appointmentDTO;
    }

    /*
        - Function: edit
        - Purpose: used to edit a single appointment
    */
    @Transactional
    public AppointmentDTO edit(Long appointment_id, AppointmentDTO newApp)
    {
        Appointment original = appointmentRepository.findById(appointment_id).get();

        // only attempt if there is actually an appointment
        if(original != null)
        {
            // sets the meeting type if the newApp has a non-null value
            original.setAppointmentType((newApp.getAppointmentType() != null) ? newApp.getAppointmentType() : original.getAppointmentType());

            if(newApp.getLocation() == null && newApp.getTime() != null && checkAppointmentAvailability(newApp.getTime(), original.getLocation())) {
                    original.setTime(newApp.getTime());
            }
            else if (newApp.getTime() == null && newApp.getLocation() != null
                    && checkAppointmentAvailability(original.getTime(), locationRepository.findById(newApp.getLocation().getId()).orElseThrow(() -> new IllegalArgumentException("Check location ID")))) {
                original.setLocation(locationRepository.findById(newApp.getLocation().getId()).get());
            }
            else if (newApp.getTime() != null && newApp.getLocation() != null
                && checkAppointmentAvailability(newApp.getTime(), locationRepository.findById(newApp.getLocation().getId()).orElseThrow(() -> new IllegalArgumentException("Check location ID")))) {
                original.setTime(newApp.getTime());
                original.setLocation(locationRepository.findById(newApp.getLocation().getId()).get());
            }
        }

        return createResponseDTO(original);
    }

    /*
        - Function: findAllAppointments
        - Purpose: used to find all appointments
    */
    @Transactional(readOnly = true)
    public List<AppointmentDTO> findAllCustomerAppointments(Long customerID) {
        Customer customer = customerRepository.findById(customerID).orElseThrow(() -> new IllegalArgumentException("Check appointment ID"));;
        List<AppointmentDTO> appointmentDTOs = new ArrayList<AppointmentDTO>();

        for(Appointment a: customer.getAppointments()) {
            appointmentDTOs.add(createResponseDTO(a));
        }
        return appointmentDTOs;
    }

    /*
        - Function: findAppointment
        - Purpose: used to find a single appointment
    */
    @Transactional(readOnly = true)
    public AppointmentDTO findAppointment(Long appId) { return createResponseDTO(appointmentRepository.findById(appId).orElseThrow(() -> new IllegalArgumentException("Check appointment ID"))); }

    @Transactional(readOnly = true)
    public List<AppointmentDTO> findEveryAppointment() {
        List<Appointment> apps = appointmentRepository.findAll();
        List<AppointmentDTO> appointmentDTOs = new ArrayList<AppointmentDTO>();

        for(Appointment a : apps){
            appointmentDTOs.add(createResponseDTO(a));
        }
        return appointmentDTOs;
    }
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
    private Boolean checkAppointmentAvailability(LocalDateTime appTime, Location appLoc)
    {
        // list of all the stored appointments
        List<Appointment> appointmentList = appointmentRepository.findAll();

        // Compares the appointment trying to be edited/created to the ones in the Database
        for(Appointment a : appointmentList)
        {
            if(appLoc.getId() == a.getLocation().getId() && appTime != null)
            {
                double timeDiff = calculateTimeDifference(appTime, a.getTime());
                if (timeDiff >= 0 && timeDiff < 1) { return false; }
            }
        }
        return true;
    }

    private double calculateTimeDifference(LocalDateTime a, LocalDateTime b) {
        return Math.abs (((a.toEpochSecond(ZoneOffset.UTC)
                - b.toEpochSecond(ZoneOffset.UTC)) / 60.0) / 60.0);
    }

    public AppointmentDTO createResponseDTO(Appointment a) {
        AppointmentDTO aDTO = new AppointmentDTO();
        aDTO.setAppointmentId(a.getId());
        aDTO.setAppointmentType(a.getAppointmentType());
        aDTO.setTime(a.getTime());
        aDTO.setLocation(locationService.createResponseDTO(a.getLocation()));
        return aDTO;
    }

    public Appointment createAppointment(AppointmentDTO aDTO) {
        Appointment a = new Appointment();
        a.setAppointmentType(aDTO.getAppointmentType());
        a.setId(aDTO.getAppointmentId());
        a.setTime(aDTO.getTime());
        a.setLocation(locationService.createLocation(aDTO.getLocation()));
        return a;
    }
}
