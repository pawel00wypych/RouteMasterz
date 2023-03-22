package com.routemasterz.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrucksFleetController {

    private final TruckService truckService;


    @GetMapping(path = "/driver/truck")
    public String truckInfo() {
        return null;
    }

    @GetMapping(path = "/logistician/trucks")
    public String availableTrucks() {
        return null;
    }

    @PostMapping(path = "/driver/truck",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String setTruckInfo(@RequestBody DriverTruckRequest request) {
        return truckService.setTruckInfo(request);
    }

    @PostMapping(path = "/logistician/trucks", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addRoutes(@RequestBody LogisticianSetRouteRequest request) {
        return truckService.addRoutes(request);
    }
}
