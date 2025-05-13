package com.example.dassi.Converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dassi.DTOs.StationDTO;
import com.example.dassi.Models.Station;
import com.example.dassi.Repositories.LineRepo;
import com.example.dassi.Repositories.StationLineRepo;

public class StationConverter {
    @Autowired
    private LineRepo lineRepo;
    @Autowired
    private StationLineRepo stationLineRepo;

    public StationDTO toDTO(Station station) {
        StationDTO stationDTO = new StationDTO();
        stationDTO.setId(station.getId());
        stationDTO.setLinesIds(
                station.getStationLines().stream().map(x -> x.getLine().getId()).collect(Collectors.toList()));
        stationDTO.setName(station.getName());
        stationDTO.setNumber(station.getNumber());
        return stationDTO;
    }

    public Station toModel(StationDTO stationDTO) {
        Station station = new Station();
        station.setId(stationDTO.getId());
        station.setName(stationDTO.getName());
        station.setNumber(stationDTO.getNumber());
        station.setStationLines(
                stationDTO.getLinesIds() == null || stationDTO.getLinesIds().isEmpty() ? new ArrayList<>()
                        : stationDTO.getLinesIds().stream()
                                .map(x -> stationLineRepo.findByStationIdAndLineId(stationDTO.getId(), x))
                                .filter(Optional::isPresent).map(Optional::get)
                                .collect(Collectors.toList()));
        return station;
    }

    public List<StationDTO> toListDTO(List<Station> stations) {
        return stations.stream().map(teach -> toDTO(teach)).collect(Collectors.toList());
    }

    public List<Station> toListModel(List<StationDTO> stationDTOs) {
        return stationDTOs.stream().map(teach -> toModel(teach)).collect(Collectors.toList());
    }
}
