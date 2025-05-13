package com.example.dassi.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "station", fetch = FetchType.LAZY)
    private List<StationLine> stationLines;

    public boolean equals(Object o) {
        if (o instanceof Station)
            if (this.id == ((Station) o).id &&
                    this.name == ((Station) o).name
                    && this.number == ((Station) o).number)
                return true;
        return false;
    }

}
