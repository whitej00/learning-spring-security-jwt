package com.example.testsecurityjwt.repository;

import com.example.testsecurityjwt.Entity.User;
import com.example.testsecurityjwt.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Boolean existsByUsername(String username);

    UserDto findByUsername(String username);
}
