package com.example.Gilgamesh.Commerce.Project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    @OneToMany( mappedBy = "customer" )
    private List<Appointment> appointments = new ArrayList<>();

    public boolean equals(Customer c) {
        if (this.firstName.equals(c.firstName)
                && this.lastName.equals(c.lastName)
                && this.email.equals(c.email)) {
            return true;
        }
        return false;
    }
}
