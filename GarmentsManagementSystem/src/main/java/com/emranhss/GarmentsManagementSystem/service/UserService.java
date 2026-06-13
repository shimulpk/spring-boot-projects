package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User u);
    List<User> findAll();
    Optional<User> getById(Long id);
    void delete(Long id);
}
