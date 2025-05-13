package com.example.dassi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.dassi.DTOs.StationDTO;
import com.example.dassi.Models.Station;
import com.example.dassi.Services.StationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/Station")
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping
    public ResponseEntity<List<StationDTO>> getAll() {
        return ResponseEntity.ok(stationService.getAllStationes());
    }

    @PostMapping
    public ResponseEntity<Boolean> add(StationDTO station) {
        return ResponseEntity.ok(stationService.createStation(station));
    }
}