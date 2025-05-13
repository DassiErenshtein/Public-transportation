package com.example.dassi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.dassi.Converters.StationConverter;
import com.example.dassi.DTOs.StationDTO;
import com.example.dassi.Models.Station;
import com.example.dassi.Repositories.StationRepo;

@Service
public class StationService {
    @Autowired
    private StationRepo stationRepo;
    @Autowired
    private StationConverter stationConverter;

    public List<StationDTO> getAllStationes() {
        return stationConverter.toListDTO(stationRepo.findAll());
    }

    public boolean createStation(StationDTO stationDTO) {
        Station station = stationConverter.toModel(stationDTO);
        if (station != null && !stationRepo.exists(Example.of(station))) {
            try {
                stationRepo.save(station);
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
