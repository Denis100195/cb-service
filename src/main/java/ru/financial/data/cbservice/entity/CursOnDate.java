package ru.financial.data.cbservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursOnDate {

    private LocalDate date;
    private String name;
    private Long nom;
    private Double curs;
    private Integer code;
    private String chCode;
    private Double unitRate;
}
