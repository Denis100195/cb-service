package ru.financial.data.cbservice.domain.service;

import ru.financial.data.cbservice.entity.CursOnDate;
import ru.financial.data.cbservice.entity.KeyRate;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.List;

public interface CursOnDateService {
    void saveCursOnDate(LocalDate date) throws DatatypeConfigurationException;
    CursOnDate getCursOnDate(LocalDate date);
    List<CursOnDate> getCursOnDateBetweenDates(LocalDate fromDate, LocalDate toDate);
}
