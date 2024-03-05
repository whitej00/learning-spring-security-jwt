package com.example.testsecurityjwt.controller;

import com.example.testsecurityjwt.dto.JoinDto;
import com.example.testsecurityjwt.service.JoinService;
import com.example.testsecurityjwt.service.RefreshTokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final JoinService joinService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/v1/join")
    public String joinProcess(JoinDto joinDto){

        joinService.joinProcess(joinDto);

        return "join success!";
    }

    @PostMapping("/v1/logout")
    public String logoutProcess(HttpServletRequest request, HttpServletResponse response){
        System.out.println("hi");

        refreshTokenService.logoutProcess(request);

        return "logout success!";
    }

    @PatchMapping("/v1/refresh")
    public String reissue(HttpServletRequest request, HttpServletResponse response) {

        refreshTokenService.refresh(request, response);

        return "refreshed success!";
    }

}
