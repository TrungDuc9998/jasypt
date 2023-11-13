package com.example.test_java.service.impl;

import com.example.test_java.configuration.JwtService;
import com.example.test_java.model.Role;
import com.example.test_java.model.User;
import com.example.test_java.model.request.AuthenticationRequest;
import com.example.test_java.model.request.RegisterRequest;
import com.example.test_java.repository.UserRepository;
import com.example.test_java.response.AuthenticationResponse;
import com.example.test_java.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);

        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(user)).build();
    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(null);

        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(user)).build();
    }
}
