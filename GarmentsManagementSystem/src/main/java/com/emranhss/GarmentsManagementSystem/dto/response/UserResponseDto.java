package com.emranhss.GarmentsManagementSystem.dto.response;

import com.emranhss.GarmentsManagementSystem.enums.Role;
import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;

    private String fullName;

    private String username;

    private String email;

    private String phone;

    private Role role;

    private Boolean active;
}
