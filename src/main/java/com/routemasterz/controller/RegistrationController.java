package com.routemasterz.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegisterRequest request) {
        return registrationService.register(request);
    }

    @GetMapping
    public String confirm() {
        return null;
    }
}
