package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.dto.request.UserRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.UserResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponseDto create(UserRequestDto request);


    UserResponseDto update(Long id, UserRequestDto request);

    UserResponseDto getById(Long id);


    List<UserResponseDto> getAll();

  
    void delete(Long id);
}
