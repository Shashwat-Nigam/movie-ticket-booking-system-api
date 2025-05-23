package com.example.mtb.service;

import com.example.mtb.dto.registeration.UserRegistrationDTO;
import com.example.mtb.dto.response.UserResponseDTO;
import com.example.mtb.repository.UserRepo;

import java.util.List;

public interface UserService {

    UserResponseDTO registerUser(UserRegistrationDTO userDto);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(String userId);

    UserResponseDTO updateUser(String userId, UserRegistrationDTO userDto);

    void deleteUser(String userId);
}
