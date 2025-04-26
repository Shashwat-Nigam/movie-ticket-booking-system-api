package com.example.mtb.mapper;

import com.example.mtb.dto.registeration.ScreenRequestDTO;
import com.example.mtb.dto.response.ScreenResponseDTO;
import com.example.mtb.entity.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ScreenMapper {

    @Autowired
    private SeatMapper seatMapper;

    public Screen toEntity(ScreenRequestDTO dto) {
        if (dto == null) return null;

        Screen screen = new Screen();

        screen.setScreenId(dto.screenId());
        screen.setScreenType(dto.screenType());
        screen.setCapacity(dto.capacity());
        screen.setNoOfRows(dto.noOfRows());
        screen.setCreatedAt(dto.createdAt());
        screen.setUpdatedAt(dto.updatedAt());
        screen.setCreatedBy(dto.createdBy());
        screen.setTheaterId(dto.theaterId());

        return screen;
    }

    public ScreenResponseDTO toDTO(Screen screen) {
        if (screen == null) return null;

        return new ScreenResponseDTO(
                screen.getScreenId(),
                screen.getScreenType(),
                screen.getCapacity(),
                screen.getNoOfRows(),
                screen.getCreatedAt(),
                screen.getUpdatedAt(),
                screen.getCreatedBy(),
                screen.getTheaterId(),
                (screen.getSeats() != null && !screen.getSeats().isEmpty())
                        ? screen.getSeats().stream()
                        .map(seatMapper::toDTO)  // Now correctly called
                        .collect(Collectors.toList())
                        : null
        );
    }
}
