package com.example.mtb.entity;

import com.example.mtb.enums.ScreenType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String screenId;  // primary key

    @Enumerated(EnumType.STRING)
    private ScreenType screenType;  // enum: 2D, 3D, IMAX etc.

    private Integer capacity;
    private Integer noOfRows;
    private Long createdAt;
    private Long updatedAt;

    private String createdBy;  // FK User id (String)
    private String theaterId;  // FK Theater id (String)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Show> shows = new ArrayList<>();


}
