package com.example.courseprojectvm.repository;

import com.example.courseprojectvm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);
}