package com.example.Gilgamesh.Commerce.Project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    // This auto generates the ID number for the objects of type Appointment
    private Long id;

    // What is the nature of the meeting
    private MeetingType appointmentType;

    // The date and time of the given appointment
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnore
    private Location location;
}
