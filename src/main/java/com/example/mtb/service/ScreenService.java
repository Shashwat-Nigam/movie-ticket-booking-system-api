package com.example.mtb.service;

import com.example.mtb.dto.registeration.ScreenRequestDTO;
import com.example.mtb.dto.response.ScreenResponseDTO;
import com.example.mtb.dto.registeration.ScreenRequestDTO;

import java.util.List;

public interface ScreenService {

    ScreenResponseDTO createScreen(ScreenRequestDTO screenRequestDTO);

}
