package com.example.courseprojectvm.repository;

import com.example.courseprojectvm.entity.CatCitizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatCitizenRepository extends JpaRepository<CatCitizen, Long> {
}
