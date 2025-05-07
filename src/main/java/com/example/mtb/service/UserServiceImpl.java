package com.example.mtb.service;

import com.example.mtb.dto.registeration.UserRegistrationDTO;
import com.example.mtb.dto.response.UserResponseDTO;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.UserRole;
import com.example.mtb.mapper.UserMapper;
import com.example.mtb.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserResponseDTO registerUser(UserRegistrationDTO userRegistrationDTO) {
        UserDetails user = UserMapper.toEntity(userRegistrationDTO);

        if (user.getUserRole() == null) {
            user.setUserRole(UserRole.USER);
        }

        Long now = Instant.now().toEpochMilli();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        UserDetails savedUser = userRepo.save(user);
        return UserMapper.toResponseDTO(savedUser);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .filter(user -> !user.isDeleted()) // Exclude soft-deleted users
                .map(UserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(String userId) {
        UserDetails user = userRepo.findById(userId)
                .filter(u -> !u.isDeleted())
                .orElseThrow(() -> new RuntimeException("User not found with id: " ));
        return UserMapper.toResponseDTO(user);
    }

    @Override
    public UserResponseDTO updateUser(String userId, UserRegistrationDTO userRegistrationDTO) {
        UserDetails existingUser = userRepo.findById(userId)
                .filter(u -> !u.isDeleted())
                .orElseThrow(() -> new RuntimeException("User not found with id: "));

        existingUser.setUserName(userRegistrationDTO.username());
        existingUser.setEmail(userRegistrationDTO.email());
        existingUser.setPassword(userRegistrationDTO.password());
        existingUser.setUserRole(userRegistrationDTO.userRole() != null ? userRegistrationDTO.userRole() : existingUser.getUserRole());
        existingUser.setPhoneNumber(userRegistrationDTO.phoneNumber());
        existingUser.setDateOfBirth(userRegistrationDTO.dateOfBirth());
        existingUser.setUpdatedAt(Instant.now().toEpochMilli());

        UserDetails updatedUser = userRepo.save(existingUser);
        return UserMapper.toResponseDTO(updatedUser);
    }

    @Override
    public void deleteUser(String userId) {
        UserDetails user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " ));

        user.softDelete(); // Perform soft delete
        userRepo.save(user);
    }
}
