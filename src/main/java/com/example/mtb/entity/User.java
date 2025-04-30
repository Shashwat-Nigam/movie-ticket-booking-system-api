package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends UserDetails{
    @Id
    private String userId;

    @OneToOne
    @JoinColumn(name="userId", referencedColumnName = "userId", insertable = false, updatable = false)
    private UserDetails userDetails;
}
