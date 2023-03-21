package com.routemasterz.controller;

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

    @PostMapping(path = "/setEmail")
    public String setEmail(@RequestBody UserRequest request) {
        return userService.setEmail(request);
    }

    @PostMapping(path = "/setNewPassword")
    public String setNewPassword(@RequestBody UserRequest request) {
        return userService.setNewPassword(request);
    }

    @PostMapping(path = "/logout")
    public String logout(@RequestBody UserRequest request) {
        return userService.logout(request);
    }
}
