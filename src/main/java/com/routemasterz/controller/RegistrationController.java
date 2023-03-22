package com.routemasterz.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody RegisterRequest request) {
        return registrationService.register(request);
    }

    @GetMapping
    public String confirm() {
        return null;
    }
}
