package com.example.mtb.service;

import com.example.mtb.entity.UserDetails;
import com.example.mtb.repository.UserDetailsRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsRepo userDetailsRepo;

    public UserDetailsServiceImpl(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }

    @Override
    public UserDetails createUser(UserDetails userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        long now = Instant.now().toEpochMilli();
        userDetails.setCreatedAt(now);
        userDetails.setUpdatedAt(now);
        return userDetailsRepo.save(userDetails);
    }

    @Override
    public List<UserDetails> getAllUsers() {
        return userDetailsRepo.findAll();
    }
}

