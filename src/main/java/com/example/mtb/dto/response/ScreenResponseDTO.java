package com.example.mtb.dto.response;

import com.example.mtb.enums.ScreenType;
import java.util.List;

public record ScreenResponseDTO(
        String screenId,
        ScreenType screenType,
        Integer capacity,
        Integer noOfRows,
        Long createdAt,
        Long updatedAt,
        String createdBy,
        String theaterId,
        List<SeatResponseDTO> seats  // Assuming SeatResponseDTO is a record for seats
) {}
