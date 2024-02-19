package com.example.testsecurityjwt.controller;

import com.example.testsecurityjwt.dto.JoinDto;
import com.example.testsecurityjwt.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(JoinDto joinDto){

        joinService.joinProcess(joinDto);
        return "ok";
    }
}
