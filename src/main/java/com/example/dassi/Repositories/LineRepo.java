package com.example.dassi.Repositories;

import com.example.dassi.Models.Line;
import com.example.dassi.Models.Station;

import java.sql.Time;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepo extends JpaRepository<Line, Long> {

}