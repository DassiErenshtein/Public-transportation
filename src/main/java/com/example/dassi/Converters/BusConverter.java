package com.example.dassi.Converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dassi.DTOs.BusDTO;
import com.example.dassi.Models.Bus;
import com.example.dassi.Models.Travel;
import com.example.dassi.Repositories.TravelRepo;

public class BusConverter {

    @Autowired
    private TravelRepo travelRepo;

    public BusDTO toDTO(Bus bus) {
        BusDTO busDTO = new BusDTO();
        busDTO.setId(bus.getId());
        busDTO.setLicense_plate(bus.getLicense_plate());
        busDTO.setSeats(bus.getSeats());
        busDTO.setTravelsIds(bus.getTravels().stream().map(x -> x.getId()).collect(Collectors.toList()));
        return busDTO;
    }

    public Bus toModel(BusDTO busDTO) {
        Bus bus = new Bus();
        bus.setId(busDTO.getId());
        bus.setLicense_plate(busDTO.getLicense_plate());
        bus.setSeats(busDTO.getSeats());
        bus.setTravels(
                busDTO.getTravelsIds() == null || busDTO.getTravelsIds().isEmpty() ? new ArrayList<>()
                        : busDTO.getTravelsIds().stream().map(travelRepo::findById).filter(Optional::isPresent)
                                .map(Optional::get)
                                .collect(Collectors.toList()));
        return bus;
    }

    public List<BusDTO> toListDTO(List<Bus> buss) {
        return buss.stream().map(teach -> toDTO(teach)).collect(Collectors.toList());
    }

    public List<Bus> toListModel(List<BusDTO> busDTOs) {
        return busDTOs.stream().map(teach -> toModel(teach)).collect(Collectors.toList());
    }
}
