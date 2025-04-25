package com.example.mtb.entity;

import jakarta.persistence.*;

@Entity
public class Theater {

    @Id
    private String theaterId;

    private String name;
    private String address;
    private String city;
    private String landmark;
    private Long createdAt;
    private Long updatedAt;
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private TheaterOwner theaterOwner;

    // Getters and Setters

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public TheaterOwner getTheaterOwner() {
        return theaterOwner;
    }

    public void setTheaterOwner(TheaterOwner theaterOwner) {
        this.theaterOwner = theaterOwner;
    }
}

