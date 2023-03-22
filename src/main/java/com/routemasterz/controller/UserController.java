package com.routemasterz.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/userAccount")
    public String userAccount() {
        return null;
    }

    @PostMapping(path = "/setEmail",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String setEmail(@RequestBody UserRequest request) {
        return userService.setEmail(request);
    }

    @PostMapping(path = "/setNewPassword",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String setNewPassword(@RequestBody UserRequest request) {
        return userService.setNewPassword(request);
    }

    @PostMapping(path = "/logout",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String logout(@RequestBody UserRequest request) {
        return userService.logout(request);
    }
}
