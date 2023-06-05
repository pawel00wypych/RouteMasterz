package com.routemasterz.controller;

import com.routemasterz.dto.DeleteRouteRequest;
import com.routemasterz.dto.ShowRoutesRequest;
import com.routemasterz.dto.UserCompanyRequest;
import com.routemasterz.dto.UserRoleRequest;
import com.routemasterz.service.StaffService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/app")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping(path = "/admin/changeUserRole",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changeUserRole(@RequestBody UserRoleRequest request) {
        return staffService.changeUserRole(request);
    }

    @PostMapping(path = "/admin/changeUserCompany",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changeUserCompany(@RequestBody UserCompanyRequest request) {
        return staffService.changeUserCompany(request);
    }

    @GetMapping(path = "/admin/showAllUsers",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> showAllUsers() {
        return staffService.showAllUsers();
    }

    @GetMapping(path = "/driver/showJobDetails",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String showJobDetails() {
        return null;
    }

    @PostMapping(path = "/logistician/showRoutes",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> showRoutes(@RequestBody ShowRoutesRequest request) {
        return staffService.showRoutes(request);
    }

    @PostMapping(path = "/logistician/deleteRoute",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteRoute(@RequestBody DeleteRouteRequest request) {
        return staffService.deleteRoute(request);
    }
}
