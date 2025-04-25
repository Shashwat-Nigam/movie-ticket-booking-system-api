package com.example.mtb.mapper;

import com.example.mtb.dto.registeration.TheaterRegisterationDTO;
import com.example.mtb.dto.response.TheaterResponseDTO;
import com.example.mtb.entity.Theater;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TheaterMapper {

    public Theater toEntity(TheaterRegisterationDTO dto) {
        Theater theater = new Theater();
        theater.setTheaterId(UUID.randomUUID().toString());
        theater.setName(dto.getName());
        theater.setAddress(dto.getAddress());
        theater.setCity(dto.getCity());
        theater.setLandmark(dto.getLandmark());
        theater.setCreatedAt(System.currentTimeMillis());
        theater.setUpdatedAt(System.currentTimeMillis());
        theater.setCreatedBy("SYSTEM"); // Replace with current user if needed
        return theater;
    }

    public TheaterResponseDTO toDto(Theater theater) {
        TheaterResponseDTO dto = new TheaterResponseDTO();
        dto.setTheaterId(theater.getTheaterId());
        dto.setName(theater.getName());
        dto.setAddress(theater.getAddress());
        dto.setCity(theater.getCity());
        dto.setLandmark(theater.getLandmark());
        dto.setCreatedAt(theater.getCreatedAt());
        dto.setUpdatedAt(theater.getUpdatedAt());
        dto.setCreatedBy(theater.getCreatedBy());
        return dto;
    }
}
