package com.example.courseprojectvm.converter;

import com.example.courseprojectvm.dto.UserRequestDTO;
import com.example.courseprojectvm.entity.Role;
import com.example.courseprojectvm.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User convert(UserRequestDTO request, Set<Role> roles) {
        return User.builder()
                .username(request.username())
                .password(bCryptPasswordEncoder.encode(request.password()))
                .roles(roles)
                .build();
    }
}
