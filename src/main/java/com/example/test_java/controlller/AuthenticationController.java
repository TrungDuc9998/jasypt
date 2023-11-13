package com.example.test_java.controlller;

import com.example.test_java.model.Person;
import com.example.test_java.model.dto.PersonDTO;
import com.example.test_java.model.request.AuthenticationRequest;
import com.example.test_java.model.request.RegisterRequest;
import com.example.test_java.response.AuthenticationResponse;
import com.example.test_java.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok().body(this.authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok().body(this.authenticationService.authentication(request));
    }

}
