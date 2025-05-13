package com.example.dassi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.dassi.Converters.DriverConverter;
import com.example.dassi.DTOs.DriverDTO;
import com.example.dassi.Models.Driver;
import com.example.dassi.Repositories.DriverRepo;

@Service
public class DriverService {
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private DriverConverter driverConverter;

    public List<DriverDTO> getAllDriveres() {
        return driverConverter.toListDTO(driverRepo.findAll());
    }

    public boolean createDriver(DriverDTO driverDTO) {
        Driver driver = driverConverter.toModel(driverDTO);
        if (driver != null && !driverRepo.exists(Example.of(driver))) {
            try {
                driverRepo.save(driver);
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
