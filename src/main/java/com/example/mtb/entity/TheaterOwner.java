package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="theater_owners")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterOwner {
    @Id
    private String userId;
    @OneToOne
    @JoinColumn(name="userId", referencedColumnName = "userId", insertable = false, updatable = false)
    private UserDetails userDetails;
}
