package com.example.testsecurityjwt.repository;

import com.example.testsecurityjwt.Entity.RefreshToken;
import com.example.testsecurityjwt.dto.RefreshTokenDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.OptionalInt;

public interface RefreshRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshTokenDto> findByUsername(String username);
    void deleteAllByUsername(String username);
}
