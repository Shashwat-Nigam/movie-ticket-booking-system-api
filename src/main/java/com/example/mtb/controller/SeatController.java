package com.example.mtb.controller;

import com.example.mtb.dto.registeration.SeatRequestDTO;
import com.example.mtb.dto.response.SeatResponseDTO;
import com.example.mtb.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping
    public SeatResponseDTO createSeat(@RequestBody SeatRequestDTO seatRequestDTO) {
        return seatService.createSeat(seatRequestDTO);
    }
}
