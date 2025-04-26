package com.example.mtb.entity;

import com.example.mtb.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="user_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetails {
    @Id
    private String userId;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private String PhoneNumber;
    private LocalDate DateOfBirth;
    private long CreatedAt;
    private long UpdatedAt;


}
