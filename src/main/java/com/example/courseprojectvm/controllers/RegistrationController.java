package com.example.courseprojectvm.controllers;

import com.example.courseprojectvm.entities.UserRequest;
import com.example.courseprojectvm.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<Boolean> registerUser(@RequestBody UserRequest request) {
        boolean isSaved = userService.saveUser(request);
        return new ResponseEntity<>(isSaved ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}