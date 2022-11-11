package com.example.Gilgamesh.Commerce.Project.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDTO {
    private Long id;

    private String streetAddress;

    private String city;

    private String state;

    private Long zipCode;
}
