package com.example.mtb.mapper;

import com.example.mtb.dto.response.UserResponseDTO;
import com.example.mtb.entity.UserDetails;

public class UserResponseMapper {

    public static UserResponseDTO toDTO(UserDetails user) {
        if (user == null) {
            return null;
        }

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
