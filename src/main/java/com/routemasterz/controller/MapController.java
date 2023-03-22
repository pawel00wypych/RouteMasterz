package com.routemasterz.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

    private final MapService mapService;

    @GetMapping(path = "/driver/map")
    public String showDriverMap() {
        return null;
    }

    @GetMapping(path = "/driver/map/routes")
    public String showDriverRoutes() {
        return null;
    }

    @GetMapping(path = "/logistician/map")
    public String showLogisticianMap() {
        return null;
    }

    @PostMapping(path = "/logistician/map/setPlace",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String setPlace(@RequestBody PlaceRequest request) {
        return mapService.setPlace(request);
    }

    @PostMapping(path = "/logistician/map/saveRoute",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveRoute(@RequestBody RouteRequest request) {
        return mapService.saveRoute(request);
    }

}
