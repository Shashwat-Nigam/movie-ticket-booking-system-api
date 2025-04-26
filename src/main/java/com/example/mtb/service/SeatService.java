package com.example.mtb.service;

import com.example.mtb.dto.registeration.SeatRequestDTO;
import com.example.mtb.dto.response.SeatResponseDTO;

import java.util.List;

public interface SeatService {
    SeatResponseDTO createSeat(SeatRequestDTO seatRequestDto);
}

