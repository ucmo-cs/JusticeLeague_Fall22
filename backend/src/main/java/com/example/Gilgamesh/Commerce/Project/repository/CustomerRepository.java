package com.example.Gilgamesh.Commerce.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Gilgamesh.Commerce.Project.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
