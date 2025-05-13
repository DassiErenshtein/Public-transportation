package com.example.dassi.DTOs;

import java.util.List;

import com.example.dassi.Models.Station;
import com.example.dassi.Models.StationLineId;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @IdClass(StationLineId.class)
public class StationLineDTO {

    // @Id
    // @ManyToOne
    // @JoinColumn(name = "station_id")
    private Long stationId;
    // @Id
    // @ManyToOne
    // @JoinColumn(name = "line_id")
    private Long lineId;
    private int stationOrder;
}
