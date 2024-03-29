package com.example.testsecurityjwt.dto;

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
