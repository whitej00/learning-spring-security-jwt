package com.example.testsecurityjwt.service;

import com.example.testsecurityjwt.Entity.UserEntity;
import com.example.testsecurityjwt.dto.JoinDto;
import com.example.testsecurityjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto){

        String username = joinDto.getUsername();
        String password = joinDto.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if(isExist){

            return;
        }

        userRepository.save(UserEntity.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .role("ROLE_ADMIN")
                .build());
    }
}
