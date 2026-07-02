package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.UserMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.UserRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.UserResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.User;
import com.emranhss.GarmentsManagementSystem.repository.UserRepository;
import com.emranhss.GarmentsManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto create(UserRequestDto request) {
        // Check duplicate email
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }

        // Check duplicate phone
        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone already exists.");
        }


        User user = userMapper.toEntity(request);

        // Password BCrypt Encode
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save
        user = userRepository.save(user);

        // Entity → ResponseDTO
        return userMapper.toResponseDto(user);


}

    @Override
    public UserResponseDto update(Long id, UserRequestDto request) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id : " + id));

        // Update entity
        userMapper.updateEntity(request, user);

        // Encode password only if changed
        if (request.getPassword() != null &&
                !request.getPassword().isBlank()) {

            user.setPassword(
                    passwordEncoder.encode(request.getPassword())
            );
        }

        user = userRepository.save(user);

        return userMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id : " + id));

        return userMapper.toResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id : " + id));

        userRepository.delete(user);
    }
}
