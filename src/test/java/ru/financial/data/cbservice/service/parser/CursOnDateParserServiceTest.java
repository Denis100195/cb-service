package ru.financial.data.cbservice.service.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.financial.data.cbservice.entity.CursOnDate;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class CursOnDateParserServiceTest {
    @Autowired
    CursOnDateParserService cursOnDateParserService;
    @Test
    void cursOnDateParse() throws DatatypeConfigurationException {
        List<CursOnDate> cursOnDateList = cursOnDateParserService.cursOnDateParse(
                LocalDate.of(2023, 11, 12)
        );
        System.out.println(cursOnDateList);
        Assertions.assertNotNull(cursOnDateList);
    }
}