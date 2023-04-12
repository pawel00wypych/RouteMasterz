package com.routemasterz.controller;

import com.routemasterz.dto.AddRouteRequest;
import com.routemasterz.dto.SetTruckInfoRequest;
import com.routemasterz.service.TruckService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/app")
public class TrucksFleetController {

    private final TruckService truckService;

    public TrucksFleetController(TruckService truckService) {
        this.truckService = truckService;
    }


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
    public String setTruckInfo(@RequestBody SetTruckInfoRequest request) {
        return truckService.setTruckInfo(request);
    }

    @PostMapping(path = "/logistician/trucks", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addRoutes(@RequestBody AddRouteRequest request) {
        return truckService.addRoutes(request);
    }
}
