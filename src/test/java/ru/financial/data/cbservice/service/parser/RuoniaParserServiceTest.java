package ru.financial.data.cbservice.service.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.financial.data.cbservice.entity.Ruonia;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class RuoniaParserServiceTest {
    @Autowired
    RuoniaParserService ruoniaParserService;
    @Test
    void ruoniaParse() throws DatatypeConfigurationException {
        List<Ruonia> ruoniaList = ruoniaParserService.ruoniaParse(
                LocalDate.of(2020, 1, 11),
                LocalDate.of(2020, 1, 16)
        );
        System.out.println(ruoniaList);
        Assertions.assertNotNull(ruoniaList);
    }
}