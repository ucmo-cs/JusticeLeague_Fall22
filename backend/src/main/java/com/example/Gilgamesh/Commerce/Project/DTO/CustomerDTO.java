package com.example.Gilgamesh.Commerce.Project.DTO;

import com.example.Gilgamesh.Commerce.Project.domain.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO {
    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private List<Appointment> appointments = new ArrayList<>();
}
