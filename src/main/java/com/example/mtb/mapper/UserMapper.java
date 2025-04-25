package com.example.mtb.mapper;

import com.example.mtb.dto.registeration.UserRegistrationDTO;
import com.example.mtb.dto.response.UserResponseDTO;
import com.example.mtb.entity.UserDetails;

public class UserMapper {

    public static UserDetails toEntity(UserRegistrationDTO dto) {
        return UserDetails.builder()
                .userName(dto.userName())
                .email(dto.email())
                .password(dto.password())
                .userRole(dto.role())
                .build();

    }

    public static UserResponseDTO toResponseDTO(UserDetails user) {
        return UserResponseDTO.builder()
                .id(user.getUserId())
                .username(user.getUserName())
                .email(user.getEmail())
                .role(user.getUserRole())
                .build();
    }
}
