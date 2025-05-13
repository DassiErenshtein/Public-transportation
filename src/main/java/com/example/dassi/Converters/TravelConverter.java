package com.example.dassi.Converters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dassi.DTOs.TravelDTO;
import com.example.dassi.Models.Bus;
import com.example.dassi.Models.Driver;
import com.example.dassi.Models.Line;
import com.example.dassi.Models.Travel;
import com.example.dassi.Repositories.BusRepo;
import com.example.dassi.Repositories.DriverRepo;
import com.example.dassi.Repositories.LineRepo;

public class TravelConverter {
    @Autowired
    private BusRepo busRepo;
    @Autowired
    private LineRepo lineRepo;
    @Autowired
    private DriverRepo driverRepo;

    public TravelDTO toDTO(Travel travel) {
        TravelDTO travelDTO = new TravelDTO();
        travelDTO.setId(travel.getId());
        travelDTO.setDriverId(travel.getDriver().getId());
        travelDTO.setBusId(travel.getBus().getId());
        ;
        travelDTO.setLineId(travel.getLine().getId());
        travelDTO.setDepartureTime(travel.getDepartureTime());
        return travelDTO;
    }

    public Travel toModel(TravelDTO travelDTO) {
        Travel travel = new Travel();
        travel.setId(travelDTO.getId());
        Bus b = busRepo.findById(travelDTO.getBusId()).get();
        if (b != null) {
            travel.setBus(b);
        } else {
            return null;
        }
        travel.setDepartureTime(travelDTO.getDepartureTime());
        Line l = lineRepo.findById(travelDTO.getLineId()).get();
        if (l != null) {
            travel.setLine(l);
        } else {
            return null;
        }
        Driver d = driverRepo.findById(travelDTO.getDriverId()).get();
        if (d != null) {
            travel.setDriver(d);
        } else {
            return null;
        }
        return travel;
    }

    public List<TravelDTO> toListDTO(List<Travel> Travels) {
        return Travels.stream().map(teach -> toDTO(teach)).collect(Collectors.toList());
    }

    public List<Travel> toListModel(List<TravelDTO> TravelDTOs) {
        return TravelDTOs.stream().map(teach -> toModel(teach)).collect(Collectors.toList());
    }
}
