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
import com.example.dassi.Repositories.LineRepo;
import com.example.dassi.Repositories.StationLineRepo;

@Service
public class StationLineService {
    @Autowired
    private StationLineRepo stationLineRepo;
    @Autowired
    private StationLineConverter stationLineConverter;
    @Autowired
    private LineRepo lineRepo;

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
        if (stationLine != null) {
            try {
                List<StationLine> list = lineRepo.findById(stationLineDTO.getLineId()).get().getStationLines();
                // stationLineRepo.filterByLineId(stationLineDTO.getLineId());
                list.stream()
                        .filter(x -> x.getStationOrder() <= stationLineDTO.getStationOrder()
                                && x.getStationOrder() < stationLine.getStationOrder())
                        .forEach(x -> {
                            x.setStationOrder(x.getStationOrder() + 1);
                            stationLineRepo.save(x);
                        });

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
        // Optional o = stationLineRepo.filterByLineId(stationLineDTO.getLineId());
        // if (!o.isPresent()) {
        // return false;
        // }

        StationLine stationLine = stationLineConverter.toModel(stationLineDTO);
        if (stationLine != null && !stationLineRepo.exists(Example.of(stationLine))) {
            List<StationLine> list = lineRepo.findById(stationLineDTO.getLineId()).get().getStationLines();
            stationLineDTO.setStationOrder(
                    list
                            .stream()
                            .mapToInt(s -> s.getStationOrder())
                            .max()
                            .orElse(0) + 1);
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
