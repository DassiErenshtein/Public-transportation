package com.example.dassi.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.dassi.DTOs.LineDTO;
import com.example.dassi.Models.Line;
import com.example.dassi.Services.LineService;

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
@RequestMapping("/Line")
public class LineController {

    @Autowired
    private LineService lineService;

    @GetMapping
    public ResponseEntity<List<LineDTO>> getAll() {
        return ResponseEntity.ok(lineService.getAllLinees());
    }

    @PostMapping
    public ResponseEntity<Boolean> add(LineDTO line) {
        // Line.setId((long) 0);
        return ResponseEntity.ok(lineService.createLine(line));
    }
}