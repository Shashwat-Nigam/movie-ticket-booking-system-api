package com.example.mtb.mapper;

import com.example.mtb.dto.registeration.SeatRequestDTO;
import com.example.mtb.dto.response.SeatResponseDTO;
import com.example.mtb.entity.Screen;
import com.example.mtb.entity.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {

    public Seat toEntity(SeatRequestDTO seatRequestDto, Screen screen) {

        Seat seat = new Seat();
        seat.setSeatId(seatRequestDto.getSeatId());
        seat.setSeatNumber(seatRequestDto.getSeatNumber());
        seat.setSeatType(seatRequestDto.getSeatType());
        seat.setIsAvailable(seatRequestDto.getIsAvailable());
        seat.setScreen(screen);

        // Auto-generate seatName
        if (seatRequestDto.getRowNumber() != null && seatRequestDto.getSeatNumber() != null) {
            char rowChar = (char) ('A' + seatRequestDto.getRowNumber());
            seat.setSeatName(rowChar + String.valueOf(seatRequestDto.getSeatNumber()));
        } else {
            seat.setSeatName("Unknown Seat");
        }
        return seat;
    }

    public SeatResponseDTO toDTO(Seat seat) {
        SeatResponseDTO seatResponseDto = new SeatResponseDTO();
        seatResponseDto.setSeatId(seat.getSeatId());
        seatResponseDto.setSeatNumber(seat.getSeatNumber());
        seatResponseDto.setSeatName(seat.getSeatName());
        seatResponseDto.setSeatType(seat.getSeatType());
        seatResponseDto.setIsAvailable(seat.getIsAvailable());
        seatResponseDto.setCreatedAt(seat.getCreatedAt());
        seatResponseDto.setScreenId(seat.getScreen() != null ? seat.getScreen().getScreenId() : null);
        return seatResponseDto;
    }
}
