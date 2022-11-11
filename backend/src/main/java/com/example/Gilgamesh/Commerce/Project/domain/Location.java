package com.example.Gilgamesh.Commerce.Project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.example.Gilgamesh.Commerce.Project.domain.Appointment;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    // This auto generates the ID number for the location
    private Long id;

    private String streetAddress;

    private String city;

    private String state;

    private Long zipCode;

    @OneToMany( mappedBy = "location" )
    private List<Appointment> appointments = new ArrayList<>();

    public boolean equalLocations(Location l)
    {
        return l != null && this.streetAddress.equals(l.getStreetAddress()) && this.city.equals(l.getCity());
    }
}
