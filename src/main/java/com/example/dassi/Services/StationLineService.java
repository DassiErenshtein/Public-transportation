package com.example.dassi.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.dassi.Converters.StationLineConverter;
import com.example.dassi.DTOs.StationLineDTO;
import com.example.dassi.Models.StationLine;
import com.example.dassi.Repositories.StationLineRepo;

@Service
public class StationLineService {
    @Autowired
    private StationLineRepo stationLineRepo;
    @Autowired
    private StationLineConverter stationLineConverter;

    public List<StationLineDTO> getAllStationLines() {
        return stationLineConverter.toListDTO(stationLineRepo.findAll());
    }

    public boolean updateStationLine(StationLineDTO stationLineDTO) {
        if (stationLineDTO.getLineId() == null || stationLineDTO.getStationId() == null
                || stationLineDTO.getStationOrder() <= 0) {
            return false;
        }
        StationLine stationLine = stationLineRepo.findByStationIdAndLineId(stationLineDTO.getStationId(),
                stationLineDTO.getLineId()).get();
        stationLineRepo.filterByLineId(stationLineDTO.getLineId())
                .filter(x -> ((StationLine) x).getStationOrder() > stationLineDTO.getStationOrder()).stream()
                .forEach(x -> {
                    StationLine s = ((StationLine) x);
                    s.setStationOrder(s.getStationOrder() + 1);
                    stationLineRepo.save(s);
                    try {
                        stationLineRepo.save(s);
                    } catch (Exception error) {
                        error.printStackTrace();
                        System.out.println("שגיאה" + error.getMessage());
                    }
                });
        if (stationLine != null) {
            try {
                stationLine.setStationOrder(stationLineDTO.getStationOrder());
                stationLineRepo.save(stationLine);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("שגיאה" + e.getMessage());
                return false;
            }
        }

        return false;
    }

    public boolean createStationLine(StationLineDTO stationLineDTO) {
        if (stationLineDTO.getLineId() == null || stationLineDTO.getStationId() == null) {
            return false;
        }
        stationLineDTO.setStationOrder(
                stationLineRepo.filterByLineId(stationLineDTO.getLineId())
                        .stream()
                        .mapToInt(s -> ((StationLine) s).getStationOrder())
                        .max()
                        .orElse(0) + 1);
        StationLine stationLine = stationLineConverter.toModel(stationLineDTO);
        if (stationLine != null && !stationLineRepo.exists(Example.of(stationLine))) {
            try {
                stationLineRepo.save(stationLine);
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
