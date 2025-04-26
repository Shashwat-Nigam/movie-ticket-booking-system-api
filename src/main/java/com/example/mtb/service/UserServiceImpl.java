package com.example.mtb.service;

import com.example.mtb.dto.registeration.UserRegistrationDTO;
import com.example.mtb.dto.response.UserResponseDTO;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.UserRole;
import com.example.mtb.mapper.UserMapper;
import com.example.mtb.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    @Override
    public UserResponseDTO registerUser(UserRegistrationDTO userDto) {
        UserDetails user = UserMapper.toEntity(userDto);

        if (user.getUserRole() == null) {
            user.setUserRole(UserRole.USER);
        }

        long now = System.currentTimeMillis();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        UserDetails savedUser = userRepository.save(user);
        return UserMapper.toResponseDTO(savedUser);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(String id) {
        UserDetails user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return UserMapper.toResponseDTO(user);
    }

    @Override
    public UserResponseDTO updateUser(String id, UserRegistrationDTO userDto) {
        UserDetails existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existingUser.setUserName(userDto.username());
        existingUser.setEmail(userDto.email());
        existingUser.setPassword(userDto.password());
        existingUser.setUserRole(userDto.userRole() != null ? userDto.userRole() : existingUser.getUserRole());
        existingUser.setPhoneNumber(userDto.phoneNumber());
        existingUser.setDateOfBirth(userDto.dateOfBirth());
        existingUser.setUpdatedAt(System.currentTimeMillis());

        UserDetails updatedUser = userRepository.save(existingUser);
        return UserMapper.toResponseDTO(updatedUser);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
