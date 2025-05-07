package com.example.mtb.entity;

import com.example.mtb.enums.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.cert.Certificate;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="movies")
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @NotBlank
    @Column(name="movie_id", unique = true)
    private String movieId;

    @NotBlank
    @Column(name="title")
    private String title;

    @Column(name="description", columnDefinition="TEXT")
    private String description;

    @ElementCollection
    @CollectionTable(name = "movie_cast", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "cast_member")
    private Set<String> cast = new HashSet<>();

    @NotNull
    @Column(name = "runtime")
    private Duration runtime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "certificate")
    private Certificate certificate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

}
