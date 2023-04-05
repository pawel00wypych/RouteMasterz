package com.routemasterz.service;

import com.routemasterz.dto.DeleteRouteRequest;
import com.routemasterz.dto.ShowStaffRequest;
import com.routemasterz.dto.UserRoleRequest;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    public String changeUserRole(UserRoleRequest request) {
        return "role changed";
    }

    public String showStaff(ShowStaffRequest request) {
        return "staff";
    }

    public String deleteRoute(DeleteRouteRequest request) {
        return "deleted";
    }
}
