package com.routemasterz.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {

    private final StaffService staffService;

    @GetMapping(path = "/admin")
    public String adminPanel() {
        return null;
    }

    @PostMapping(path = "/admin/changeUserRole",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String changeUserRole(@RequestBody UserRoleRequest request) {
        return staffService.changeUserRole(request);
    }

    @GetMapping(path = "/driver/showJobDetails",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String showJobDetails() {
        return null;
    }

    @GetMapping(path = "/logistician/showStaff",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String showStaff(@RequestBody ShowStaffRequest request) {
        return staffService.showStaff(request);
    }

    @PostMapping(path = "/logistician/deleteRoute",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteRoute(@RequestBody DeleteRouteRequest request) {
        return staffService.deleteRoute(request);
    }
}
