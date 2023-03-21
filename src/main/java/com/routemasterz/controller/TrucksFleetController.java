package com.routemasterz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(path = "/driver/truck")
    public String setTruckInfo(@RequestBody DriverTruckRequest request) {
        return truckService.setTruckInfo(request);
    }

    @PostMapping(path = "/logistician/trucks/{worker_id}")
    public String addRoute(@RequestBody LogisticianTruckRequest request) {
        return truckService.addRoute(request);
    }
}
