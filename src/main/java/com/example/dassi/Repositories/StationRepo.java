package com.example.dassi.Repositories;

import com.example.dassi.Models.Station;
import com.example.dassi.Models.Travel;

import java.sql.Time;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends JpaRepository<Station, Long> {
    Optional<Station> findById(Long id);

}
