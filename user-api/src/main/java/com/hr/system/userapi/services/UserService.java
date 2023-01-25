package com.hr.system.userapi.services;

import com.hr.system.userapi.domain.User;
import lombok.NoArgsConstructor;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
}
