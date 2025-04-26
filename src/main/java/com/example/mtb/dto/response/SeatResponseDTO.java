package com.example.mtb.dto.response;

import com.example.mtb.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatResponseDTO {


    private String seatId;
    private String seatNumber;
    private SeatType seatType;
    private Boolean isAvailable;
    private Long createdAt;
    private String screenId;

}
