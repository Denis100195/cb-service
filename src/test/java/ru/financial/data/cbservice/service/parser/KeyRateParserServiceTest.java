package ru.financial.data.cbservice.service.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.financial.data.cbservice.entity.KeyRate;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class KeyRateParserServiceTest {
    @Autowired
    KeyRateParserService keyRateParserService;
    @Test
    void keyRateParse() throws DatatypeConfigurationException {
        List<KeyRate> keyRateList = keyRateParserService.keyRateParse(
                LocalDate.of(2023, 1, 11),
                LocalDate.of(2023, 1, 16)
        );
        System.out.println(keyRateList);
        Assertions.assertNotNull(keyRateList);
    }
}