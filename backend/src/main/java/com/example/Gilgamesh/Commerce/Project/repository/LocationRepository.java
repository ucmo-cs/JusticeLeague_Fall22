package com.example.Gilgamesh.Commerce.Project.repository;

import com.example.Gilgamesh.Commerce.Project.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
