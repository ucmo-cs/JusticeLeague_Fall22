package com.example.Gilgamesh.Commerce.Project.service;

import com.example.Gilgamesh.Commerce.Project.domain.Appointment;
import com.example.Gilgamesh.Commerce.Project.repository.AppointmentRepository;
import com.example.Gilgamesh.Commerce.Project.repository.CustomerRepository;
import com.example.Gilgamesh.Commerce.Project.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AppointmentRepository appointmentRepository;

    @Transactional
    public Customer create(Customer cust){
        return customerRepository.save(cust);
    }

    @Transactional(readOnly = true)
    public Customer find(Long custID){
        return customerRepository.findById(custID).orElseThrow(() -> new IllegalArgumentException("Check customer ID"));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Transactional
    public String delete(Long custId) {
        Customer c = customerRepository.findById(custId).orElseThrow(() -> new IllegalArgumentException("Check customer Id"));

        List<Appointment> customerAppointments = c.getAppointments();

        while(!c.getAppointments().isEmpty()) {
            appointmentRepository.deleteById(customerAppointments.get(0).getId());
            customerAppointments.remove(0);
        }

        customerRepository.deleteById(custId);
        return "ok - customer deleted";
    }


    @Transactional
    public Customer edit(Long custID, Customer editCust) {
        Customer oldCust = customerRepository.findById(custID).orElseThrow(() -> new IllegalArgumentException("Check customer ID"));

        if(!oldCust.equals(editCust)) {
            oldCust.setFirstName((editCust.getFirstName() != null) ? editCust.getFirstName() : oldCust.getFirstName());
            oldCust.setLastName((editCust.getLastName() != null) ? editCust.getLastName() : oldCust.getLastName());
            oldCust.setEmail((editCust.getEmail() != null) ? editCust.getEmail() : oldCust.getEmail());
            oldCust.setPhoneNumber((editCust.getPhoneNumber() != null) ? editCust.getPhoneNumber() : oldCust.getPhoneNumber());
        }

        return oldCust;
    }
}
