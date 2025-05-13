package com.example.dassi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.dassi.Converters.StationLineConverter;
import com.example.dassi.DTOs.StationLineDTO;
import com.example.dassi.Models.StationLine;
import com.example.dassi.Services.StationLineService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/StationLine")
public class StationLineController {

    @Autowired
    private StationLineService stationLineService;
    @Autowired
    private StationLineConverter stationLineConverter;

    @GetMapping
    public ResponseEntity<List<StationLineDTO>> getAll() {
        return ResponseEntity.ok(stationLineService.getAllStationLines());
    }

    @PostMapping
    public ResponseEntity<Boolean> add(StationLineDTO stationLine) {
        return ResponseEntity.ok(stationLineService.createStationLine(stationLine));
    }

    @PutMapping
    public ResponseEntity<Boolean> update(StationLineDTO stationLine) {
        return ResponseEntity.ok(stationLineService.updateStationLine(stationLine));
    }
}