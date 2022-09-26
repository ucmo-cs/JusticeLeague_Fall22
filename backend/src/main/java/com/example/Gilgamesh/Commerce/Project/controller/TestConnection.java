package com.example.Gilgamesh.Commerce.Project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestConnection {

    @PostMapping("/Test")
    public ResponseEntity<?> test(@RequestBody String outStr) {
        System.out.println(outStr);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
