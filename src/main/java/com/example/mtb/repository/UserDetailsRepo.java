package com.example.mtb.repository;

import com.example.mtb.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails, String> {
}
