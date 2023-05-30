package com.routemasterz.controller;

import com.routemasterz.dto.GetUserRequest;
import com.routemasterz.dto.SetEmailRequest;
import com.routemasterz.dto.SetNewPasswordRequest;
import com.routemasterz.service.UserService;
import com.routemasterz.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/app")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLoggedUser(@RequestBody GetUserRequest request) {
        return userService.getLoggedUser(request);
    }

    @PostMapping(path = "/setEmail",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String setEmail(@RequestBody SetEmailRequest request) {
        return userService.setEmail(request);
    }

    @PostMapping(path = "/setNewPassword",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String setNewPassword(@RequestBody SetNewPasswordRequest request) {
        return userService.setNewPassword(request);
    }

    @PostMapping(path = "/logout",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String logout() {
        return userService.logout();
    }
}
