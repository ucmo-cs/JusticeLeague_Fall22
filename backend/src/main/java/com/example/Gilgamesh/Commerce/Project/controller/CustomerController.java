package com.example.Gilgamesh.Commerce.Project.controller;

import com.example.Gilgamesh.Commerce.Project.DTO.CustomerDTO;
import com.example.Gilgamesh.Commerce.Project.service.CustomerService;
import com.example.Gilgamesh.Commerce.Project.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO cust) {
        return new ResponseEntity<>(customerService.create(cust), HttpStatus.OK);
    }

    @GetMapping("/customer={customerId}")
    public ResponseEntity<?> findCustomer(@PathVariable Long customerId) {
        return new ResponseEntity<>(customerService.find(customerId), HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity<?> findAllCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/customer={customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        return new ResponseEntity<>(customerService.delete(customerId), HttpStatus.OK);
    }

    @PatchMapping("/customer={customerId}")
    public ResponseEntity<?> editCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customer) {
        return new ResponseEntity<>(customerService.edit(customerId, customer), HttpStatus.OK);
    }

}
