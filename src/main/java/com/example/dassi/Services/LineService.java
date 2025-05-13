package com.example.dassi.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.dassi.Converters.LineConverter;
import com.example.dassi.DTOs.LineDTO;
import com.example.dassi.Models.Line;
import com.example.dassi.Models.Station;
import com.example.dassi.Models.StationLine;
import com.example.dassi.Repositories.LineRepo;
import com.example.dassi.Repositories.StationLineRepo;
import com.example.dassi.Repositories.StationRepo;

@Service
public class LineService {
    @Autowired
    private LineRepo lineRepo;
    @Autowired
    private LineConverter lineConverter;
    @Autowired
    private StationLineRepo stationLineRepo;
    @Autowired
    private StationRepo stationRepo;

    public List<LineDTO> getAllLinees() {
        return lineConverter.toListDTO(lineRepo.findAll());
    }

    public boolean createLine(LineDTO lineDTO) {
        Line line = lineConverter.toModel(lineDTO);
        if (line != null && !lineRepo.exists(Example.of(line))) {

            try {
                lineRepo.save(line);
                // line.setStationLines(
                // lineDTO.getStationsIds() == null || lineDTO.getStationsIds().isEmpty() ? new
                // ArrayList<>()
                // :
                // lineDTO.getStationsIds().stream().map(x -> {
                // Optional s = stationRepo.findById(x);
                // if (!s.isPresent())
                // return null;
                // return new StationLine((Station) s.get(), line,
                // counter.getAndIncrement());
                // }).filter(x -> x.getStation() != null)
                // .collect(Collectors.toList()).forEach(x -> {
                // stationLineRepo.save(x);
                // });
                // stationLineRepo.saveAll(null)
                // .filter(Optional::isPresent).map(Optional::get)
                // .collect(Collectors.toList())
                // );

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
