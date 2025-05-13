package com.example.dassi.Repositories;

import com.example.dassi.Models.Line;
import com.example.dassi.Models.Station;
import com.example.dassi.Models.StationLine;
import com.example.dassi.Models.StationLineId;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StationLineRepo extends JpaRepository<StationLine, StationLineId> {
    public Optional<StationLine> findByStationIdAndLineId(Long stationId, Long lineId);

    // public Optional<List<StationLine>> filterByLineId(Long lineId);
}
