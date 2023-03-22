package com.routemasterz.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }

    @GetMapping
    public String confirm() {
        return null;
    }
}
