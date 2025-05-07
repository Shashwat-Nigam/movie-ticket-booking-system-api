package com.example.mtb.mapper;

import com.example.mtb.dto.registeration.UserRegistrationDTO;
import com.example.mtb.dto.response.UserResponseDTO;
import com.example.mtb.entity.UserDetails;

public class UserMapper {

    // Convert UserRegistrationDTO (record) to UserDetails entity
    public static UserDetails toEntity(UserRegistrationDTO dto) {
        if (dto == null) return null;

        UserDetails user = new UserDetails();

        user.setUserName(dto.username());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setUserRole(dto.userRole());
        user.setPhoneNumber(dto.phoneNumber());
        user.setDateOfBirth(dto.dateOfBirth());

        return user;
    }


    // Convert UserDetails entity to UserResponseDTO (record)
    public static UserResponseDTO toResponseDTO(UserDetails user) {
        if (user == null) return null;

        return new UserResponseDTO(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getUserRole(),
                user.getPhoneNumber(),
                user.getDateOfBirth(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
