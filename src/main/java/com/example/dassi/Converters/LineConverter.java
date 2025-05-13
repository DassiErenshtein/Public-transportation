package com.example.dassi.Converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dassi.DTOs.LineDTO;
import com.example.dassi.Models.Line;
import com.example.dassi.Repositories.StationLineRepo;
import com.example.dassi.Repositories.StationRepo;
import com.example.dassi.Repositories.TravelRepo;

public class LineConverter {
    @Autowired
    private StationRepo stationRepo;
    @Autowired
    private TravelRepo travelRepo;
    @Autowired
    private StationLineRepo stationLineRepo;

    // @Autowired
    // private DriverRepo driverRepo;
    public LineDTO toDTO(Line line) {
        LineDTO lineDTO = new LineDTO();
        lineDTO.setId(line.getId());
        lineDTO.setDetinations(line.getDetinations());
        lineDTO.setNumber(line.getNumber());
        lineDTO.setSource(line.getSource());
        lineDTO.setStationsIds(
                line.getStationLines().stream().map(x -> x.getStation().getId()).collect(Collectors.toList()));
        lineDTO.setTravelsIds(line.getTravels().stream().map(x -> x.getId()).collect(Collectors.toList()));
        return lineDTO;
    }

    public Line toModel(LineDTO lineDTO) {
        Line line = new Line();
        AtomicInteger counter = new AtomicInteger(1);
        line.setId(line.getId());
        line.setDetinations(lineDTO.getDetinations());
        line.setNumber(lineDTO.getNumber());
        line.setSource(lineDTO.getSource());
        line.setTravels(lineDTO.getTravelsIds() == null || lineDTO.getTravelsIds().isEmpty() ? new ArrayList<>()
                : lineDTO.getTravelsIds().stream().map(x -> travelRepo.findById(x))
                        .filter(Optional::isPresent).map(Optional::get)
                        .collect(Collectors.toList()));
        line.setStationLines(lineDTO.getStationsIds() == null || lineDTO.getStationsIds().isEmpty() ? new ArrayList<>()
                : lineDTO.getStationsIds().stream()
                        .map(x -> stationLineRepo.findByStationIdAndLineId(x, lineDTO.getId()))
                        .filter(Optional::isPresent).map(Optional::get)
                        .collect(Collectors.toList()));
        return line;
        // line.setStationLines(lineDTO.getStationsIds().stream().map(stationRepo::findById).filter(Optional::isPresent)
        // .map(Optional::get).map(station -> {
        // StationLine sl = new StationLine(station, line, counter.getAndIncrement());
        // stationLineRepo.save(sl);
        // // List<StationLine> list = station.getStationLines();
        // return sl;
        // }).collect(Collectors.toList()));
        // // .map(x -> {
        // // Optional<Station> s = stationRepo.findById(x);
        // // if (!s.isPresent())
        // // return null;
        // // else {
        // // Station station = s.get();
        // // StationLine sl = new StationLine(station, line,
        // // counter.getAndIncrement());
        // // List<StationLine> list = station.getStationLines();
        // // if (list == null)
        // // list = new ArrayList<>();
        // // list.add(sl);
        // // station.setStationLines(list);
        // // stationRepo.save(station);
        // // return sl;
        // // }

        // // }).filter(x -> x != null && x.getStation() != null)
        // // .forEach(x -> {
        // // stationLineRepo.save(x);
        // // });
        // return line;
        // // List<StationLine> stationLines = lineDTO.getStationsIds().stream()
        // // .map(stationRepo::findById)
        // // .filter(Optional::isPresent)
        // // .map(Optional::get)
        // // .map(station -> {
        // // StationLine sl = new StationLine(station, line,
        // counter.getAndIncrement());
        // // return stationLineRepo.save(sl); // שמירה בבסיס נתונים
        // // })
        // // .collect(Collectors.toList());

        // // // קשר את ה־StationLines ל־line
        // // line.setStationLines(stationLines);
    }

    public List<LineDTO> toListDTO(List<Line> lines) {
        return lines.stream().map(x -> toDTO(x)).collect(Collectors.toList());
    }

    public List<Line> toListModel(List<LineDTO> lineDTOs) {
        return lineDTOs.stream().map(x -> toModel(x)).collect(Collectors.toList());
    }
}
