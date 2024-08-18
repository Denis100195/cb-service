package ru.financial.data.cbservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ruonia {

    private LocalDate date;
    private double ruonia;
    private double volume;
    private LocalDate dateUpdate;
}
