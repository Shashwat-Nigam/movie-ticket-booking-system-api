package com.example.mtb.service;

import com.example.mtb.dto.registeration.ScreenRequestDTO;
import com.example.mtb.dto.response.ScreenResponseDTO;
import com.example.mtb.entity.Screen;
import com.example.mtb.mapper.ScreenMapper;
import com.example.mtb.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;
    private final ScreenMapper screenMapper;

    @Override
    public ScreenResponseDTO createScreen(ScreenRequestDTO requestDTO) {
        Screen screen = screenMapper.toEntity(requestDTO);
        Screen savedScreen = screenRepository.save(screen);
        return screenMapper.toDTO(savedScreen);
    }
}
