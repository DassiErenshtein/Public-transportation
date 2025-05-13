package com.example.dassi.Converters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dassi.DTOs.StationLineDTO;
import com.example.dassi.Models.Bus;
import com.example.dassi.Models.Driver;
import com.example.dassi.Models.Line;
import com.example.dassi.Models.StationLine;
import com.example.dassi.Repositories.BusRepo;
import com.example.dassi.Repositories.DriverRepo;
import com.example.dassi.Repositories.LineRepo;
import com.example.dassi.Repositories.StationRepo;

public class StationLineConverter {
    @Autowired
    private BusRepo busRepo;
    @Autowired
    private LineRepo lineRepo;
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private LineConverter lineConverter;
    @Autowired
    private StationConverter stationConverter;
    @Autowired
    private StationRepo stationRepo;

    public StationLineDTO toDTO(StationLine stationLine) {
        StationLineDTO stationLineDTO = new StationLineDTO();
        stationLineDTO.setStationId(stationLine.getStation().getId());
        stationLineDTO.setLineId(stationLine.getLine().getId());
        stationLineDTO.setStationOrder(stationLine.getStationOrder());
        return stationLineDTO;
    }

    public StationLine toModel(StationLineDTO stationLineDTO) {
        StationLine stationLine = new StationLine();
        stationLine.setLine(lineRepo.findById(stationLineDTO.getLineId()).get());
        stationLine.setStationOrder(stationLineDTO.getStationOrder());
        stationLine.setStation(stationRepo.findById(stationLineDTO.getStationId()).get());
        return stationLine;
    }

    public List<StationLineDTO> toListDTO(List<StationLine> StationLines) {
        return StationLines.stream().map(teach -> toDTO(teach)).collect(Collectors.toList());
    }

    public List<StationLine> toListModel(List<StationLineDTO> StationLineDTOs) {
        return StationLineDTOs.stream().map(teach -> toModel(teach)).collect(Collectors.toList());
    }
}
