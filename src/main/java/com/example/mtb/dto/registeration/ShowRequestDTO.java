package com.example.mtb.dto.registeration;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShowRequestDTO {
    @NotNull(message = "Start time is required")
    @FutureOrPresent(message= "Start time must be in the present or future")
    private Long startsAt;

    @NotNull(message = "End time is required")
    @FutureOrPresent(message = "End time must be in the present or future")
    private Long endsAt;

    @NotBlank(message = "screen Id cant be blank")
    private String screenId;

    @NotBlank(message = "Movie ID is required")
    private String movieId;

    @NotBlank(message = "theater Id cannot be blank")
    private String theaterId;
}
