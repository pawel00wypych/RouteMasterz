package com.routemasterz.service;

import com.routemasterz.dto.LoginRequest;
import com.routemasterz.dto.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public String login(LoginRequest request) {
        return "logged in";
    }

    public String register(RegisterRequest request) {
        return "registered successfully";
    }
}
