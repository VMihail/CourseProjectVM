package com.example.courseprojectvm.repositories;

import com.example.courseprojectvm.entities.CatCitizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatCitizenRepository extends JpaRepository<CatCitizen, Long> {
}
