package com.routemasterz.controller;

import com.routemasterz.dto.LoginRequest;
import com.routemasterz.dto.RegisterRequest;
import com.routemasterz.service.AuthenticationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, path="login")
    public String login(@RequestBody LoginRequest request) {
        return authenticationService.login(request);
    }

    @GetMapping( path="login")
    public String showLoginPage() {
        return "login page";
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, path="register")
    public String register(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }

    @GetMapping(path="register")
    public String showRegisterPage() {
        return null;
    }
}
