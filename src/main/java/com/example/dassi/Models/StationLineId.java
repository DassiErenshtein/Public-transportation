package com.example.dassi.Models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class StationLineId implements Serializable {
    private Station station;
    private Line line;

    public StationLineId() {
    }

    public boolean equals(Object o) {
        if (o instanceof StationLineId)
            if (this.station.equals(((StationLineId) o).station) &&
                    this.line.equals(((StationLineId) o).line))
                return true;
        return false;
    }

    public int hashCode() {
        return Objects.hash(station.getId(), line.getId());
    }
}
