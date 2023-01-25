package com.hr.system.userapi.services.impl;

import com.hr.system.userapi.domain.User;
import com.hr.system.userapi.repositories.UserRepository;
import com.hr.system.userapi.services.UserService;
import com.hr.system.userapi.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Environment env;
    @Override
    public User findById(Long id) {
        log.info("User Service ::: Get request on " + env.getProperty("local.server.port") + " port");
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
