package com.example.dassi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.dassi.DTOs.BusDTO;
import com.example.dassi.Models.Bus;
import com.example.dassi.Services.BusService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public ResponseEntity<List<BusDTO>> getAll() {
        return ResponseEntity.ok(busService.getAllBuses());
    }

    @PostMapping
    public ResponseEntity<Boolean> add(BusDTO bus) {
        // bus.setId((long) 0);
        return ResponseEntity.ok(busService.createBus(bus));
    }
}