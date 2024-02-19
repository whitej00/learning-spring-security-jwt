package com.example.testsecurityjwt.repository;

import com.example.testsecurityjwt.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Boolean existsByUsername(String username);

    UserEntity findByUsername(String username);
}
