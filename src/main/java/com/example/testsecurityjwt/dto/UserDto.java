package com.example.testsecurityjwt.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String password;
    private String role;

    @Builder
    public UserDto(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
