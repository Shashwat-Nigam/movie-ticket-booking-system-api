package com.example.mtb.dto.response;

import com.example.mtb.enums.UserRole;
import lombok.Builder;

import java.time.LocalDate;

@Builder

public record UserResponseDTO(
        String userId,
        String username,
        String email,
        UserRole userRole,
        String phoneNumber,
        LocalDate dateOfBirth,
        Long createdAt,
        Long updatedAt
) {}

