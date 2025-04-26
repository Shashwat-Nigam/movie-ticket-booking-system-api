package com.example.mtb.service;

import com.example.mtb.dto.registeration.SeatRequestDTO;
import com.example.mtb.dto.response.SeatResponseDTO;
import com.example.mtb.entity.Screen;
import com.example.mtb.entity.Seat;
import com.example.mtb.mapper.SeatMapper;
import com.example.mtb.repository.ScreenRepository;
import com.example.mtb.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private SeatMapper seatMapper;

    @Override
    public SeatResponseDTO createSeat(SeatRequestDTO seatRequestDTO) {
        Screen screen = screenRepository.findById(seatRequestDTO.getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found with id: " + seatRequestDTO.getScreenId()));

        Seat seat = seatMapper.toEntity(seatRequestDTO, screen);
        Seat savedSeat = seatRepository.save(seat);

        return seatMapper.toDTO(savedSeat);
    }
}
