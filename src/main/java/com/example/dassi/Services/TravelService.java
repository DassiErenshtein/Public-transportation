package com.example.dassi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.dassi.Converters.TravelConverter;
import com.example.dassi.DTOs.TravelDTO;
import com.example.dassi.Models.Travel;
import com.example.dassi.Repositories.TravelRepo;

@Service
public class TravelService {
    @Autowired
    public TravelRepo travelRepo;
    @Autowired
    public TravelConverter travelConverter;

    public List<TravelDTO> getAllTravels() {
        return travelConverter.toListDTO(travelRepo.findAll());
    }

    public boolean createTravel(TravelDTO travelDTO) {
        Travel travel = travelConverter.toModel(travelDTO);
        if (travel != null && !travelRepo.exists(Example.of(travel))) {
            travelRepo.save(travel);
            return true;
        }
        return false;
    }
}
