package com.routemasterz.controller;

import com.routemasterz.dto.AuthenticationRequest;
import com.routemasterz.dto.LoginRequest;
import com.routemasterz.dto.RegisterRequest;
import com.routemasterz.service.AuthenticationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, path="login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        return authenticationService.login(request);
    }
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, path="register")
    public  ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }
}
