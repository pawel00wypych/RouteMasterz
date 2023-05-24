package com.routemasterz.controller;

import com.routemasterz.dto.SaveRouteRequest;
import com.routemasterz.dto.SetPlaceRequest;
import com.routemasterz.service.MapService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping(path = "/driver/map/routes")
    public String showDriverRoutes() {
        return null;
    }

    @PostMapping(path = "/logistician/map/setPlace",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String setPlace(@RequestBody SetPlaceRequest request) {
        return mapService.setPlace(request);
    }

    @PostMapping(path = "/logistician/map/saveRoute",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveRoute(@RequestBody SaveRouteRequest request) {
        return mapService.saveRoute(request);
    }

}
