package com.example.mtb.service;

import com.example.mtb.dto.registeration.TheaterRegisterationDTO;
import com.example.mtb.dto.response.TheaterResponseDTO;
import com.example.mtb.entity.Theater;
import com.example.mtb.mapper.TheaterMapper;
import com.example.mtb.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository repository;
    private final TheaterMapper mapper;

    public TheaterServiceImpl(TheaterRepository repository, TheaterMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TheaterResponseDTO createTheater(TheaterRegisterationDTO dto) {
        Theater theater = mapper.toEntity(dto);
        Theater saved = repository.save(theater);
        return mapper.toDto(saved);
    }

    @Override
    public List<TheaterResponseDTO> getAllTheaters() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TheaterResponseDTO getTheaterById(String id) {
        Theater theater = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theater not found"));
        return mapper.toDto(theater);
    }

    @Override
    public void deleteTheater(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Theater not found");
        }
        repository.deleteById(id);
    }

    @Override
    public TheaterResponseDTO updateTheater(String id, TheaterRegisterationDTO dto) {
        Theater theater = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theater not found"));

        theater.setName(dto.getName());
        theater.setAddress(dto.getAddress());
        theater.setCity(dto.getCity());
        theater.setLandmark(dto.getLandmark());
        theater.setUpdatedAt(System.currentTimeMillis());

        return mapper.toDto(repository.save(theater));
    }

}
