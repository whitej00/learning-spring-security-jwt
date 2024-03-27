package com.example.testsecurityjwt.service;


import com.example.testsecurityjwt.Entity.RefreshToken;
import com.example.testsecurityjwt.dto.RefreshTokenDto;
import com.example.testsecurityjwt.dto.UserDto;
import com.example.testsecurityjwt.jwt.JWTUtil;
import com.example.testsecurityjwt.repository.RefreshRepository;
import com.example.testsecurityjwt.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RefreshTokenService {

    private final UserRepository userRepository;
    private final RefreshRepository refreshRepository;
    private final JWTUtil jwtUtil;

    @Transactional
    public void save(RefreshTokenDto refreshTokenDto){
        RefreshToken refreshToken = RefreshToken.builder()
                .username(refreshTokenDto.getUsername())
                .refreshToken(refreshTokenDto.getRefreshToken())
                .build();

        refreshRepository.save(refreshToken);
    }

    @Transactional
    public void deleteAllByUsername(String username){

        refreshRepository.deleteAllByUsername(username);
    }

    @Transactional
    public void logoutProcess(HttpServletRequest request){

        String refreshToken = jwtUtil.getJwtToken(
                request.getHeader("Refresh")
        );

        String username = jwtUtil.getUsername(refreshToken);
        System.out.println("username = " + username);

        refreshRepository.deleteAllByUsername(username);
    }

    public void refresh(HttpServletRequest request, HttpServletResponse response){

        String refreshToken = jwtUtil.getJwtToken(
                request.getHeader("Refresh")
        );

        // refresh token is expired
        if(jwtUtil.isExpired(refreshToken)){
            return;
        }

        String username = jwtUtil.getUsername(refreshToken);

        Optional<RefreshTokenDto> optional = refreshRepository.findByUsername(username);

        // matched token does not exist
        if(optional.isEmpty()){

            return;
        }

        RefreshTokenDto dto = optional.get();

        String refreshTokenDb = jwtUtil.getJwtToken(
                dto.getRefreshToken()
        );

        if (refreshToken.equals(refreshTokenDb)) {
            UserDto userDto = userRepository.findByUsername(username);
            String accessToken = jwtUtil.createAccessToken(jwtUtil.ACCESS_TOKEN_CATEGORY, username, userDto.getRole(), jwtUtil.ACCESS_TOKEN_EXPIRED_MS);

            response.addHeader("Access", "Bearer " + accessToken);
        }
    }
}
