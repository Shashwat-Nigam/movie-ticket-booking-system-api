package com.example.mtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mtb.entity.Screen;

import java.util.Optional;

public interface ScreenRepository extends JpaRepository<Screen, String> {
    Optional<Screen> findByScreenId(String screenId);
    boolean existsByScreenId(String screenId);
    void deleteByScreenId(String screenId);
}

