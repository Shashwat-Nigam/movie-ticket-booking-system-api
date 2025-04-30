package com.example.mtb.entity;

import com.example.mtb.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name="user_details")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public  class UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String userId;

    private String userName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private Long CreatedAt;
    private Long UpdatedAt;
    private String PhoneNumber;
    private LocalDate DateOfBirth;

//    @Column(name="created-at", nullable = false, updatable = false)
//    @CreatedDate
//    private Instant CreatedAt;
//
//    @Column(name="updated-at", nullable = false)
//    @LastModifiedDate
//    private Instant UpdatedAt;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted = false;

    @Column(name = "deleted_at", nullable = true)
    private Instant deletedAt;

    public void softDelete() {
        this.isDeleted = true;
        this.deletedAt = Instant.now();
    }


}
