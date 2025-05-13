package com.example.dassi.Repositories;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

import com.example.dassi.DTOs.BusDTO;
import com.example.dassi.Models.Bus;

public interface BusRepo extends JpaRepository<Bus, Long> {
    // ModelMapper modelMapper = new ModelMapper();
    // Bus bus = new Bus((long) 45379, "324-522-310", 60, new ArrayList<Long>());
    // BusDTO userDTO = modelMapper.map(bus, BusDTO.class);
}
