package com.example.mtb.service;

import com.example.mtb.dto.registeration.TheaterRegisterationDTO;
import com.example.mtb.dto.response.TheaterResponseDTO;

import java.util.List;

public interface TheaterService {
    TheaterResponseDTO createTheater(TheaterRegisterationDTO dto);
    List<TheaterResponseDTO> getAllTheaters();
    TheaterResponseDTO getTheaterById(String theaterId);
    void deleteTheater(String id);
    TheaterResponseDTO updateTheater(String id, TheaterRegisterationDTO dto);

}

