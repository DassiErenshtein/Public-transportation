package com.example.dassi.DTOs;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineDTO {
    private Long id;
    private String number;
    private String source;
    private String detinations;
    private List<Long> stationsIds;
    private List<Long> travelsIds;
}
