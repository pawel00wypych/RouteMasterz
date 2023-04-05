package com.routemasterz.service;

import com.routemasterz.dto.AddRouteRequest;
import com.routemasterz.dto.SetTruckInfoRequest;
import org.springframework.stereotype.Service;

@Service
public class TruckService {
    public String setTruckInfo(SetTruckInfoRequest request) {
        return "truck info set";
    }

    public String addRoutes(AddRouteRequest request) {
        return "routes added";
    }
}
