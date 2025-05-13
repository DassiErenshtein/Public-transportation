package com.example.dassi.Repositories;

import java.sql.Time;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dassi.Models.Travel;
import java.util.List;

@Repository
public interface TravelRepo extends JpaRepository<Travel, Long> {
    Optional<Travel> findById(Long id);

}