package ru.financial.data.cbservice.domain.service;

import ru.financial.data.cbservice.entity.KeyRate;
import ru.financial.data.cbservice.entity.Ruonia;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.List;

public interface KeyRateService {
    void saveKeyRate(LocalDate fromDate, LocalDate toDate) throws DatatypeConfigurationException;
    KeyRate getKeyRateOnDate(LocalDate localDate);
    List<KeyRate> getKeyRateBetweenDates(LocalDate fromDate, LocalDate toDate);
}
