package com.example.mtb.dto.registeration;


import com.example.mtb.enums.UserRole;

public record UserRegistrationDTO(
        Long id,
        String userName,
        String email,
        String phoneNumber,
        String password,
        UserRole role
){
}
