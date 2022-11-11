package com.example.Gilgamesh.Commerce.Project.DTO;

import com.example.Gilgamesh.Commerce.Project.domain.Location;
import com.example.Gilgamesh.Commerce.Project.domain.MeetingType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentDTO {
    // the id for the meeting
    private Long appointmentId;

    // What is the nature of the meeting
    private MeetingType appointmentType;

    // The date and time of the given appointment
    private LocalDateTime time;

    // the location of the appointment
    private LocationDTO location;
}
