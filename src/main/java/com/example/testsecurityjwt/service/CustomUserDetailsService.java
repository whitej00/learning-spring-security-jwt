package com.example.testsecurityjwt.service;

import com.example.testsecurityjwt.Entity.User;
import com.example.testsecurityjwt.dto.CustomUserDetails;
import com.example.testsecurityjwt.dto.UserDto;
import com.example.testsecurityjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto userDto = userRepository.findByUsername(username);

        if(userDto != null){
            User user = User.builder()
                    .username(userDto.getUsername())
                    .password(userDto.getPassword())
                    .role(userDto.getRole())
                    .build();
            return CustomUserDetails.builder()
                    .user(user)
                    .build();
        }

        return null;
    }
}
