package ru.financial.data.cbservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.financial.data.cbservice.domain.service.RuoniaService;
import ru.financial.data.cbservice.entity.Ruonia;
import ru.financial.data.cbservice.domain.repository.RuoniaRepository;
import ru.financial.data.cbservice.service.parser.RuoniaParserService;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class RuoniaServiceImpl implements RuoniaService {
    private RuoniaRepository ruoniaRepository;
    private RuoniaParserService ruoniaParserService;
    public RuoniaServiceImpl(RuoniaRepository ruoniaRepository, RuoniaParserService ruoniaParserService){
        this.ruoniaRepository = ruoniaRepository;
        this.ruoniaParserService = ruoniaParserService;
    }
    @Override
    public void saveRuonia(LocalDate fromDate, LocalDate toDate) throws DatatypeConfigurationException {
        List<Ruonia> ruoniaList = ruoniaParserService.ruoniaParse(fromDate, toDate);
        for (Ruonia ruonia : ruoniaList){
            ruoniaRepository.insertRuonia(ruonia);
        }
    }
    @Override
    public Ruonia getRuoniaOnDate(LocalDate date) {
        return ruoniaRepository.findRuoniaOnDate(date);
    }
    @Override
    public List<Ruonia> getRuoniaBetweenDates(LocalDate fromDate, LocalDate toDate) {
        return ruoniaRepository.findRuoniaBetweenDates(fromDate, toDate);
    }
}
