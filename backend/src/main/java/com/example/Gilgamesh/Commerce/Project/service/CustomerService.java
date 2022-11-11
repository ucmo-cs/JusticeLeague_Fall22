package com.example.Gilgamesh.Commerce.Project.service;

import com.example.Gilgamesh.Commerce.Project.DTO.CustomerDTO;
import com.example.Gilgamesh.Commerce.Project.domain.Appointment;
import com.example.Gilgamesh.Commerce.Project.repository.AppointmentRepository;
import com.example.Gilgamesh.Commerce.Project.repository.CustomerRepository;
import com.example.Gilgamesh.Commerce.Project.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AppointmentRepository appointmentRepository;

    @Transactional
    public CustomerDTO create(CustomerDTO cust){
        for(Customer c : customerRepository.findAll()) {
            if(c.equals(cust)) { return new CustomerDTO(); }
        }
        customerRepository.save(generateCustomerObject(cust));
        return cust;
    }

    @Transactional(readOnly = true)
    public CustomerDTO find(Long custID){
        return generateResponseDTO(customerRepository.findById(custID).orElseThrow(() -> new IllegalArgumentException("Check customer ID")));
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> cDTO = new ArrayList<CustomerDTO>();

        for(Customer c: customerRepository.findAll()){
            cDTO.add(generateResponseDTO(c));
        }
        return cDTO;
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
    public CustomerDTO edit(Long custID, CustomerDTO editCust) {
        Customer oldCust = customerRepository.findById(custID).orElseThrow(() -> new IllegalArgumentException("Check customer ID"));

        if(!oldCust.equals(editCust)) {
            oldCust.setFirstName((editCust.getFirstName() != null) ? editCust.getFirstName() : oldCust.getFirstName());
            oldCust.setLastName((editCust.getLastName() != null) ? editCust.getLastName() : oldCust.getLastName());
            oldCust.setEmail((editCust.getEmail() != null) ? editCust.getEmail() : oldCust.getEmail());
            oldCust.setPhoneNumber((editCust.getPhoneNumber() != null) ? editCust.getPhoneNumber() : oldCust.getPhoneNumber());
        }

        return generateResponseDTO(oldCust);
    }

    private CustomerDTO generateResponseDTO(Customer cust) {
        CustomerDTO c = new CustomerDTO();
        c.setFirstName(cust.getFirstName());
        c.setLastName(cust.getLastName());
        c.setEmail(cust.getEmail());
        c.setPhoneNumber(cust.getPhoneNumber());
        c.setAppointments(cust.getAppointments());
        return c;
    }

    private Customer generateCustomerObject(CustomerDTO cust) {
        Customer c = new Customer();
        c.setFirstName(cust.getFirstName());
        c.setLastName(cust.getLastName());
        c.setEmail(cust.getEmail());
        c.setPhoneNumber(cust.getPhoneNumber());
        c.setAppointments(cust.getAppointments());
        return c;
    }
}
