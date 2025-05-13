package com.example.dassi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.dassi.DTOs.DriverDTO;
import com.example.dassi.Models.Driver;
import com.example.dassi.Services.DriverService;

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
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService DriverService;

    @GetMapping
    public ResponseEntity<List<DriverDTO>> getAll() {
        return ResponseEntity.ok(DriverService.getAllDriveres());
    }

    @PostMapping
    public ResponseEntity<Boolean> add(DriverDTO Driver) {
        // Driver.setId((long) 0);
        return ResponseEntity.ok(DriverService.createDriver(Driver));
    }
}