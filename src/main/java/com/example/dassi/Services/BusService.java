package com.example.dassi.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.dassi.Converters.BusConverter;
import com.example.dassi.DTOs.BusDTO;
import com.example.dassi.Models.Bus;
import com.example.dassi.Repositories.BusRepo;
import com.example.dassi.Repositories.TravelRepo;

@Service
public class BusService {
    @Autowired
    private BusRepo busRepo;
    @Autowired
    private BusConverter busConverter;

    public List<BusDTO> getAllBuses() {
        return busConverter.toListDTO(busRepo.findAll());
    }

    public boolean createBus(BusDTO busDTO) {
        Bus bus = busConverter.toModel(busDTO);
        if (bus != null && !busRepo.exists(Example.of(bus))) {
            try {
                busRepo.save(bus);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("שגיאה" + e.getMessage());
                return false;
            }
        }
        return false;
    }
}