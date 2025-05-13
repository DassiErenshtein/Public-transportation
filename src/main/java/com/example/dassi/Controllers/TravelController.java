package com.example.dassi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.dassi.DTOs.TravelDTO;
import com.example.dassi.Models.Travel;
import com.example.dassi.Services.TravelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping
    public ResponseEntity<List<TravelDTO>> getAll() {
        return ResponseEntity.ok(travelService.getAllTravels());
    }

    @PostMapping
    public ResponseEntity<Boolean> add(TravelDTO travel) {
        return ResponseEntity.ok(false);
    }
}