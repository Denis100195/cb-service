package ru.financial.data.cbservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RuoniaDTO {
    private long id;
    private LocalDate date;
    private double ruonia;
    private double volume;
    private LocalDate dateUpdate;
}
