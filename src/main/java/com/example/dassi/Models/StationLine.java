package com.example.dassi.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
@IdClass(StationLineId.class)
public class StationLine {
    @Id
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;
    @Id
    @ManyToOne
    @JoinColumn(name = "line_id")
    private Line line;
    private int stationOrder;
}
