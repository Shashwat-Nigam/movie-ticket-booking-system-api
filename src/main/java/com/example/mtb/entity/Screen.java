package com.example.mtb.entity;

import com.example.mtb.enums.ScreenType;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Screen {

    @Id
    private String screenId;  // primary key

    @Enumerated(EnumType.STRING)
    private ScreenType screenType;  // enum: 2D, 3D, IMAX etc.

    private Integer capacity;
    private Integer noOfRows;
    private Long createdAt;
    private Long updatedAt;

    private String createdBy;  // FK User id (String)
    private String theaterId;  // FK Theater id (String)

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;

    // Getters and setters (use Lombok @Getter @Setter if you want)

    public String getScreenId() { return screenId; }
    public void setScreenId(String screenId) { this.screenId = screenId; }

    public ScreenType getScreenType() { return screenType; }
    public void setScreenType(ScreenType screenType) { this.screenType = screenType; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Integer getNoOfRows() { return noOfRows; }
    public void setNoOfRows(Integer noOfRows) { this.noOfRows = noOfRows; }

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    public Long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getTheaterId() { return theaterId; }
    public void setTheaterId(String theaterId) { this.theaterId = theaterId; }

    public List<Seat> getSeats() { return seats; }
    public void setSeats(List<Seat> seats) { this.seats = seats; }
}
