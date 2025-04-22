package com.example.mtb.repository;

import com.example.mtb.entity.TheaterOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterOwnerRepo extends JpaRepository<TheaterOwner, String> {
}
