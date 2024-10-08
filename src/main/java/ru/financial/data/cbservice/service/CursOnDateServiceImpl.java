package ru.financial.data.cbservice.service;

import org.springframework.stereotype.Service;
import ru.financial.data.cbservice.client.CbrClient;
import ru.financial.data.cbservice.domain.repository.CursOnDateRepository;
import ru.financial.data.cbservice.domain.service.CursOnDateService;
import ru.financial.data.cbservice.entity.CursOnDate;
import ru.financial.data.cbservice.service.parser.CursOnDateParserService;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.List;

@Service
public class CursOnDateServiceImpl implements CursOnDateService {
    private CursOnDateRepository cursOnDateRepository;
    private CursOnDateParserService cursOnDateParserService;
    public CursOnDateServiceImpl(CursOnDateRepository cursOnDateRepository, CursOnDateParserService cursOnDateParserService) {
        this.cursOnDateRepository = cursOnDateRepository;
        this.cursOnDateParserService = cursOnDateParserService;
    }
    @Override
    public void saveCursOnDate(LocalDate date) throws DatatypeConfigurationException {
        List<CursOnDate> cursOnDateList = cursOnDateParserService.cursOnDateParse(date);
        for (CursOnDate cursOnDate : cursOnDateList){
            cursOnDateRepository.insertCursOnDate(cursOnDate);
        }
    }
    @Override
    public CursOnDate getCursOnDate(LocalDate localDate) {
        return null;
    }

    @Override
    public List<CursOnDate> getCursOnDateBetweenDates(LocalDate fromDate, LocalDate toDate) {
        return null;
    }
}
