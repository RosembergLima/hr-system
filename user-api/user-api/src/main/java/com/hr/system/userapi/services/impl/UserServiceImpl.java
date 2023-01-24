package com.hr.system.userapi.services.impl;

import com.hr.system.userapi.domain.User;
import com.hr.system.userapi.repositories.UserRepository;
import com.hr.system.userapi.services.UserService;
import com.hr.system.userapi.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
