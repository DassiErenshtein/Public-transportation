package com.example.dassi.DTOs;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationDTO {
    private Long id;
    private String name;
    private int number;
    private List<Long> linesIds;

}
