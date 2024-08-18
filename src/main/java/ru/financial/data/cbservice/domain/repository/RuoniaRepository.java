package ru.financial.data.cbservice.domain.repository;

import ru.financial.data.cbservice.entity.Ruonia;

import java.time.LocalDate;
import java.util.List;

public interface RuoniaRepository {
    void insertRuonia(Ruonia ruonia);
    List<Ruonia> findRuoniaBetweenDates(LocalDate fromDate, LocalDate toDate);
    Ruonia findRuoniaOnDate(LocalDate date);
}
