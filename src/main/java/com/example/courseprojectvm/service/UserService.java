package com.example.courseprojectvm.service;

import com.example.courseprojectvm.converter.UserConverter;
import com.example.courseprojectvm.entity.User;
import com.example.courseprojectvm.dto.UserRequestDTO;
import com.example.courseprojectvm.repository.RoleRepository;
import com.example.courseprojectvm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserConverter userConverter;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User %s not found".formatted(username));
        }

        return user;
    }

    @Transactional
    public User save(UserRequestDTO request) {
        User user = userRepository.getByUsername(request.username());
        if (user != null) {
            log.warn("User {} already exists.", request.username());
            return user;
        }
        return userRepository.save(
                userConverter.convert(request, Set.of(roleRepository.getByName("ROLE_USER")))
        );
    }

}