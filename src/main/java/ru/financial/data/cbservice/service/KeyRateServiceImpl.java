package ru.financial.data.cbservice.service;

import org.springframework.stereotype.Service;
import ru.financial.data.cbservice.client.CbrClient;
import ru.financial.data.cbservice.domain.service.KeyRateService;
import ru.financial.data.cbservice.entity.KeyRate;
import ru.financial.data.cbservice.domain.repository.KeyRateRepository;
import ru.financial.data.cbservice.service.parser.KeyRateParserService;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.List;

@Service
public class KeyRateServiceImpl implements KeyRateService {
    private KeyRateRepository keyRateRepository;
    private KeyRateParserService keyRateParserService;
    public KeyRateServiceImpl(KeyRateRepository keyRateRepository, KeyRateParserService keyRateParserService) {
        this.keyRateRepository = keyRateRepository;
        this.keyRateParserService = keyRateParserService;
    }
    @Override
    public void saveKeyRate(LocalDate fromDate, LocalDate toDate) throws DatatypeConfigurationException {
        List<KeyRate> keyRateList = keyRateParserService.keyRateParse(fromDate, toDate);
        for (KeyRate keyRate : keyRateList){
            keyRateRepository.insertKeyRate(keyRate);
        }
    }
    @Override
    public KeyRate getKeyRateOnDate(LocalDate date) {
        return keyRateRepository.findKeyRateOnDate(date);
    }
    @Override
    public List<KeyRate> getKeyRateBetweenDates(LocalDate fromDate, LocalDate toDate) {
        return keyRateRepository.findKeyRateBetweenDates(fromDate, toDate);
    }
}
