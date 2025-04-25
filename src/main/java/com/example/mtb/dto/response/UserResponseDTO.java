package com.example.mtb.dto.response;

import com.example.mtb.enums.UserRole;
import lombok.Builder;

@Builder

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        UserRole role
) {}

