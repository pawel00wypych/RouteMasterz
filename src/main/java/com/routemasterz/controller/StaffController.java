package com.routemasterz.controller;

import com.routemasterz.dto.DeleteRouteRequest;
import com.routemasterz.dto.ShowRoutesRequest;
import com.routemasterz.dto.UserRoleRequest;
import com.routemasterz.service.StaffService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/app")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

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

    @GetMapping(path = "/logistician/showRoutes",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String showRoutes(@RequestBody ShowRoutesRequest request) {
        return staffService.showRoutes(request);
    }

    @PostMapping(path = "/logistician/deleteRoute",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteRoute(@RequestBody DeleteRouteRequest request) {
        return staffService.deleteRoute(request);
    }
}
