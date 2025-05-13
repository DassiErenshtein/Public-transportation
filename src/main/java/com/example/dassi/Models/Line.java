package com.example.dassi.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String source;
    private String detinations;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "line", fetch = FetchType.LAZY)
    private List<StationLine> stationLines;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "line", fetch = FetchType.LAZY)
    private List<Travel> travels;

    public boolean equals(Object o) {
        if (o instanceof Line)
            if (this.id == ((Line) o).id &&
                    this.source == ((Line) o).source
                    && this.number == ((Line) o).number &&
                    this.detinations == ((Line) o).detinations)
                return true;
        return false;
    }
}
