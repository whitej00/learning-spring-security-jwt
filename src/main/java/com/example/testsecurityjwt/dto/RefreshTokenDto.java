package com.example.testsecurityjwt.dto;

import com.example.testsecurityjwt.Entity.RefreshToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
public class RefreshTokenDto {

    private String username;
    private String refreshToken;

    @Builder
    public RefreshTokenDto(String username, String refreshToken) {
        this.username = username;
        this.refreshToken = refreshToken;
    }
}
