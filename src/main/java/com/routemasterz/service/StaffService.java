package com.routemasterz.service;

import com.routemasterz.dto.DeleteRouteRequest;
import com.routemasterz.dto.ShowRoutesRequest;
import com.routemasterz.dto.UserRoleRequest;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    public String changeUserRole(UserRoleRequest request) {
        return "role changed";
    }

    public String showRoutes(ShowRoutesRequest request) {
        return "staff";
    }

    public String deleteRoute(DeleteRouteRequest request) {
        return "deleted";
    }
}
