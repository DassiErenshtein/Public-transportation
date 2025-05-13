package com.example.dassi.Converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dassi.DTOs.DriverDTO;
import com.example.dassi.Models.Driver;
import com.example.dassi.Repositories.TravelRepo;

public class DriverConverter {
    @Autowired
    private TravelRepo travelRepo;

    public DriverDTO toDTO(Driver driver) {
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(driver.getId());
        driverDTO.setName(driver.getName());
        driverDTO.setPhone(driver.getPhone());
        driverDTO
                .setTravelsIds(driver.getTravels().stream().map(travel -> travel.getId()).collect(Collectors.toList()));
        return driverDTO;
    }

    public Driver toModel(DriverDTO driverDTO) {
        Driver driver = new Driver();
        driver.setId(driverDTO.getId());
        driver.setName(driverDTO.getName());
        driver.setPhone(driverDTO.getPhone());
        driver.setTravels(driverDTO.getTravelsIds() == null || driverDTO.getTravelsIds().isEmpty() ? new ArrayList<>()
                : driverDTO.getTravelsIds().stream().map(travelId -> travelRepo.findById(travelId))
                        .filter(Optional::isPresent).map(Optional::get)
                        .collect(Collectors.toList()));
        return driver;
    }

    public List<DriverDTO> toListDTO(List<Driver> drivers) {
        return drivers.stream().map(teach -> toDTO(teach)).collect(Collectors.toList());
    }

    public List<Driver> toListModel(List<DriverDTO> driverDTOs) {
        return driverDTOs.stream().map(teach -> toModel(teach)).collect(Collectors.toList());
    }
}
