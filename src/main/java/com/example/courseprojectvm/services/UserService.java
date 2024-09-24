package com.example.courseprojectvm.services;

import com.example.courseprojectvm.entities.User;
import com.example.courseprojectvm.entities.UserRequest;
import com.example.courseprojectvm.repositories.RoleRepository;
import com.example.courseprojectvm.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User %s not found".formatted(username));
        }

        return user;
    }

    public boolean saveUser(UserRequest request) {
        User userFromDB = userRepository.getByUsername(request.username());
        if (userFromDB != null) {
            return false;
        }
        userRepository.save(
                User.builder()
                        .username(request.username())
                        .password(bCryptPasswordEncoder.encode(request.password()))
                        .roles(Collections.singleton(roleRepository.getByName("ROLE_USER")))
                        .build());
        return true;
    }

}