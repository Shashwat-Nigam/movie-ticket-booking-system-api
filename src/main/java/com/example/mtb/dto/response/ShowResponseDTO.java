package com.example.mtb.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShowResponseDTO {
    private String showId;
    private Long startsAt;
    private Long endsAt;
    private Long createdAt;
    private Long updatedAt;
    private String createdBy;
    private String screenId;
    private String screenName;
    private String theaterId;
    private String theaterName;
    private String movieId;
    private String movieTitle;
}
