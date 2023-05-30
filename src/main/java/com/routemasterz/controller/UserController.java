package com.routemasterz.controller;

import com.routemasterz.dto.GetUserRequest;
import com.routemasterz.dto.SetPhoneRequest;
import com.routemasterz.dto.SetNewPasswordRequest;
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

    @PostMapping(path = "/account/setNewPhone",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setNewPhone(@RequestBody SetPhoneRequest request) {
        return userService.setNewPhone(request);
    }

    @PostMapping(path = "/account/setNewPassword",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setNewPassword(@RequestBody SetNewPasswordRequest request) {
        return userService.setNewPassword(request);
    }

    @PostMapping(path = "/account/getUserDetails",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserDetails(@RequestBody GetUserRequest request) {
        return userService.getUserDetails(request);
    }
}
