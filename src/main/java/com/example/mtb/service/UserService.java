package com.example.mtb.service;

import com.example.mtb.dto.registeration.UserRegistrationDTO;
import com.example.mtb.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO registerUser(UserRegistrationDTO userDto);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);

    UserResponseDTO updateUser(Long id, UserRegistrationDTO userDto);

    void deleteUser(Long id);
}
