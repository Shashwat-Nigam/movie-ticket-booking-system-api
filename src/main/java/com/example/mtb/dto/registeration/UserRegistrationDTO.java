package com.example.mtb.dto.registeration;


import com.example.mtb.enums.UserRole;

import java.time.LocalDate;

public record UserRegistrationDTO(
        String userId,
        String username,
        String email,
        String password,
        UserRole userRole,
        String phoneNumber,
        LocalDate dateOfBirth
){
}
