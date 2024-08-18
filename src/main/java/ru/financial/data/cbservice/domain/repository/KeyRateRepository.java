package ru.financial.data.cbservice.domain.repository;

import ru.financial.data.cbservice.entity.KeyRate;

import java.time.LocalDate;
import java.util.List;

public interface KeyRateRepository {
    void insertKeyRate(KeyRate keyRate);

    List<KeyRate> findKeyRateBetweenDates(LocalDate fromDate, LocalDate toDate);
    KeyRate findKeyRateOnDate(LocalDate date);
}
