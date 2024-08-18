package ru.financial.data.cbservice.domain.service;

import ru.financial.data.cbservice.entity.Ruonia;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.List;

public interface RuoniaService {
    void saveRuonia(LocalDate fromDate, LocalDate toDate) throws DatatypeConfigurationException;
    Ruonia getRuoniaOnDate(LocalDate localDate);
    List<Ruonia> getRuoniaBetweenDates(LocalDate fromDate, LocalDate toDate);

}
