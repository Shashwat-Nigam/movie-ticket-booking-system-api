package com.example.mtb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "shows")
@Data
@NoArgsConstructor
public class Show {
    @Id
    @NotBlank
    @Column(name="show_id" , unique = true)
    private String showId;

    @NotNull
    @Column(name="starts_at")
    private Long startsAt;

    @NotNull
    @Column(name="ends_at")
    private Long endsAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable=false, updatable = false)
    private Long createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Long updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User createdByUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", insertable = false, updatable = false)
    private Screen screen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id", referencedColumnName = "theater_id", insertable = false, updatable = false)
    private Theater theater;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", insertable = false, updatable = false)
    private Movie movie;




}
