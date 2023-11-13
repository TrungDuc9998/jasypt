package com.example.test_java.service;

import com.example.test_java.model.request.AuthenticationRequest;
import com.example.test_java.model.request.RegisterRequest;
import com.example.test_java.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authentication(AuthenticationRequest request);
}
