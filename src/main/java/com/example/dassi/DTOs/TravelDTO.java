package com.example.dassi.DTOs;

import java.sql.Time;
import java.util.List;

import com.example.dassi.Models.Bus;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelDTO {
    private Long id;
    private Long busId;
    private Long driverId;
    private Long lineId;
    private Time departureTime;
}
