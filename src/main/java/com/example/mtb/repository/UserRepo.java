package com.example.mtb.repository;

import com.example.mtb.dto.registeration.UserRegistrationDTO;
import com.example.mtb.entity.UserDetails;
import org.apache.el.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, String> {
    boolean existsByEmail(String email);

    Optional<UserDetails> findByEmail(String email);

}
