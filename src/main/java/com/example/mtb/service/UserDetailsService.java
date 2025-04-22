package com.example.mtb.service;

import com.example.mtb.entity.UserDetails;

import java.util.List;

public interface UserDetailsService {
    UserDetails createUser(UserDetails userDetails);
    List<UserDetails> getAllUsers();
}
