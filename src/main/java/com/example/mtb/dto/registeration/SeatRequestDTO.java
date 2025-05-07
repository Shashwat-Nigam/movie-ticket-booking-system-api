package com.example.mtb.dto.registeration;

import com.example.mtb.enums.SeatType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SeatRequestDTO {

    private String seatId;
    private String seatNumber;
    private SeatType seatType;
    private Boolean isAvailable;
    private String screenId;
    private Long createdAt;
    private Integer rowNumber;

}
