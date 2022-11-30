package com.example.Gilgamesh.Commerce.Project.controller;

import com.example.Gilgamesh.Commerce.Project.DTO.LocationDTO;
import com.example.Gilgamesh.Commerce.Project.domain.Location;
import com.example.Gilgamesh.Commerce.Project.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/location")
    public ResponseEntity<?> create(@RequestBody LocationDTO l) {
        return new ResponseEntity<>(locationService.create(l), HttpStatus.CREATED);
    }

    @GetMapping("/location")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(locationService.findAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/location={locationID}")
    public ResponseEntity<?> findLocation(@PathVariable long locationID) {
        return new ResponseEntity<>(locationService.getLocation(locationID), HttpStatus.OK);
    }

    @PatchMapping("/location={locationID}")
    public ResponseEntity<?> editLocation(@PathVariable long locationID, @RequestBody LocationDTO loc) {
        return new ResponseEntity<>(locationService.editLocation(locationID, loc), HttpStatus.OK);
    }

    @DeleteMapping("/location={locationID}")
    public ResponseEntity<?> delete(@PathVariable long locationID) {
        return new ResponseEntity<>(locationService.deleteLocation(locationID), HttpStatus.OK);
    }
}
