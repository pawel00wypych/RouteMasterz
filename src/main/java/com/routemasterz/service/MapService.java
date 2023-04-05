package com.routemasterz.service;

import com.routemasterz.dto.SaveRouteRequest;
import com.routemasterz.dto.SetPlaceRequest;
import org.springframework.stereotype.Service;

@Service
public class MapService {
    public String setPlace(SetPlaceRequest request) {
        return "place set";
    }

    public String saveRoute(SaveRouteRequest request) {
        return "route saved";
    }
}
