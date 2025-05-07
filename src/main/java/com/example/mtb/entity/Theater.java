package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String theaterId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String landmark;

    private Long createdAt;
    private Long updatedAt;
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private TheaterOwner theaterOwner;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private List<Screen> screens = new ArrayList<>();

}

