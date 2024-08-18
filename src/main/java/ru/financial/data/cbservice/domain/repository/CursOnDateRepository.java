package ru.financial.data.cbservice.domain.repository;

import ru.financial.data.cbservice.entity.CursOnDate;

import java.time.LocalDate;
import java.util.List;

public interface CursOnDateRepository {
    void insertCursOnDate(CursOnDate curseOnDate);

    List<CursOnDate> findCursOnDateBetweenDates(LocalDate fromDate, LocalDate toDate);
    CursOnDate findCursOnDate(LocalDate date);
}
