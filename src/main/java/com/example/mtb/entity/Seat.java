package com.example.mtb.entity;


import com.example.mtb.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    private String seatId;
    private String seatName;

    private String seatNumber;
    private Long createdAt;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private Boolean isAvailable;

    // Many seats belong to one screen
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;


    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now().toEpochMilli();
    }

}
