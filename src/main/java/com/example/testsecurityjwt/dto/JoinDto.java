package com.example.testsecurityjwt.dto;

import com.example.testsecurityjwt.Entity.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class JoinDto {

    private String username;
    private String password;

    @Builder
    public JoinDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
