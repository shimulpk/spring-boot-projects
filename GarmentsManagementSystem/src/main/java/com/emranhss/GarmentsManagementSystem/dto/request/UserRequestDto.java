package com.emranhss.GarmentsManagementSystem.dto.request;

import com.emranhss.GarmentsManagementSystem.enums.Role;
import lombok.Data;

@Data
public class UserRequestDto {
    private String fullName;

    private String username;

    private String email;

    private String phone;

    private String password;

    private Role role;
}
