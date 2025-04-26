package com.example.mtb.controller;


import com.example.mtb.dto.registeration.ScreenRequestDTO;
import com.example.mtb.dto.response.ScreenResponseDTO;
import com.example.mtb.service.ScreenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    // Create a new Screen
    @PostMapping
    public ResponseEntity<ScreenResponseDTO> createScreen(@RequestBody ScreenRequestDTO screenRequestDTO) {
        ScreenResponseDTO createdScreen = screenService.createScreen(screenRequestDTO);
        return ResponseEntity.ok(createdScreen);
    }

}
