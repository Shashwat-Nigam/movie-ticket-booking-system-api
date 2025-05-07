package com.example.mtb.dto.registeration;

import com.example.mtb.enums.ScreenType;
import java.util.List;

public record ScreenRequestDTO(
        String screenId,
        ScreenType screenType,
        Integer capacity,
        Integer noOfRows,
        Long createdAt,
        Long updatedAt,
        String createdBy,
        String theaterId,
        List<SeatRequestDTO> seats  // Assuming SeatRequestDTO is a record for seats
) {}
