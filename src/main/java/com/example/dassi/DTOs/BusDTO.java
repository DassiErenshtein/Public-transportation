package com.example.dassi.DTOs;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusDTO {
    private Long id;
    private String license_plate;
    private int seats;
    private List<Long> travelsIds;
}
