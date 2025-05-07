package com.example.mtb.controller;

import com.example.mtb.dto.registeration.TheaterRegisterationDTO;
import com.example.mtb.dto.response.TheaterResponseDTO;
import com.example.mtb.service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    private final TheaterService service;

    public TheaterController(TheaterService service) {
        this.service = service;
    }

    // Create a theater
    @PostMapping
    public ResponseEntity<TheaterResponseDTO> createTheater(@RequestBody TheaterRegisterationDTO dto) {
        return ResponseEntity.ok(service.createTheater(dto));
    }

    // Get all theaters
    @GetMapping
    public ResponseEntity<List<TheaterResponseDTO>> getAllTheaters() {
        return ResponseEntity.ok(service.getAllTheaters());
    }

    // Get theater by ID
    @GetMapping("/{id}")
    public ResponseEntity<TheaterResponseDTO> getTheaterById(@PathVariable String id) {
        return ResponseEntity.ok(service.getTheaterById(id));
    }

    // Delete a theater by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable String id) {
        service.deleteTheater(id);
        return ResponseEntity.ok("Theater deleted successfully");
    }

    // Update a theater by ID
    @PutMapping("/{id}")
    public ResponseEntity<TheaterResponseDTO> updateTheater(
            @PathVariable String id,
            @RequestBody TheaterRegisterationDTO dto
    ) {
        return ResponseEntity.ok(service.updateTheater(id, dto));
    }
}



