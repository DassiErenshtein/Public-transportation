package com.example.dassi.Models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String license_plate;
    private int seats;
    @OneToMany(mappedBy = "bus", fetch = FetchType.LAZY)
    private List<Travel> travels = new ArrayList<>();
}
