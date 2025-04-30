package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="theater_owner")
@NoArgsConstructor
public class TheaterOwner extends UserDetails{
    @OneToMany(mappedBy = "theaterOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Theater> theaters = new ArrayList<>();


}
