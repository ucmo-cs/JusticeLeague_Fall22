package com.example.Gilgamesh.Commerce.Project.service;

import com.example.Gilgamesh.Commerce.Project.DTO.LocationDTO;
import com.example.Gilgamesh.Commerce.Project.domain.Appointment;
import com.example.Gilgamesh.Commerce.Project.domain.Customer;
import com.example.Gilgamesh.Commerce.Project.domain.Location;
import com.example.Gilgamesh.Commerce.Project.repository.AppointmentRepository;
import com.example.Gilgamesh.Commerce.Project.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final AppointmentRepository appointmentRepository;

    @Transactional
    public LocationDTO create(LocationDTO loc) {
        for(Location places: locationRepository.findAll()){
            if(places.getStreetAddress().equals(loc.getStreetAddress())) {
                throw new IllegalArgumentException("Can not create a duplicate location");
            }
        }

        Location newL = createLocation(loc);
        locationRepository.save(createLocation(loc));
        loc.setId(newL.getId());
        return loc;
    }

    @Transactional
    public LocationDTO getLocation(Long location_id){
        return createResponseDTO(locationRepository.findById(location_id).orElseThrow(() -> new IllegalArgumentException("Check location id")));
    }

    @Transactional
    public String deleteLocation(Long location_id) {
        Location l = locationRepository.findById(location_id).orElseThrow(() -> new IllegalArgumentException("Check customer Id"));

        List<Appointment> locationAppointments = l.getAppointments();

        while(!l.getAppointments().isEmpty()) {
            appointmentRepository.deleteById(locationAppointments.get(0).getId());
            locationAppointments.remove(0);
        }

        locationRepository.deleteById(location_id);
        return "ok - location deleted";
    }

    @Transactional
    public LocationDTO editLocation(long locationID, LocationDTO l) {
        Location original = locationRepository.findById(locationID).orElseThrow(() -> new IllegalArgumentException("Check location id"));

        // I am just going to make the assumption that if it changes it will change street addresses, not states, zips, or cities
        for(Location places: locationRepository.findAll()){
            if(places.getStreetAddress().equals(l.getStreetAddress())) {
                throw new IllegalArgumentException("Can not edit a location to same address of another");
            }
        }
        original.setStreetAddress(l.getStreetAddress());

        return createResponseDTO(original);
    }


    @Transactional(readOnly = true)
    public List<LocationDTO> findAllLocations() {
        List<LocationDTO> dtoList = new ArrayList<LocationDTO>();
        for(Location l : locationRepository.findAll()) {
            dtoList.add(createResponseDTO(l));
        }
        return dtoList;
    }

    public LocationDTO createResponseDTO(Location l) {
        LocationDTO lDTO = new LocationDTO();
        lDTO.setId(l.getId());
        lDTO.setStreetAddress(l.getStreetAddress());
        lDTO.setCity(l.getCity());
        lDTO.setState(l.getState());
        lDTO.setZipCode(l.getZipCode());
        return lDTO;
    }

    public Location createLocation(LocationDTO lDTO) {
        Location l = new Location();
        l.setId(lDTO.getId());
        l.setStreetAddress(lDTO.getStreetAddress());
        l.setCity(lDTO.getCity());
        l.setState(lDTO.getState());
        l.setZipCode(lDTO.getZipCode());
        return l;
    }
}
