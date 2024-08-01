package ru.financial.data.cbservice.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cbr.web.DragMetDynamicResponse;
import ru.cbr.web.GetCursOnDateResponse;
import ru.cbr.web.KeyRateResponse;
import ru.cbr.web.RuoniaResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;

@SpringBootTest
class CbrClientTest {

    @Autowired
    CbrClient cbrClient;

    @Test
    void test1() throws DatatypeConfigurationException {
        DragMetDynamicResponse.DragMetDynamicResult dragMetDynamic = cbrClient.getDragMetDynamic(
                LocalDate.of(2020, 1, 11),
                LocalDate.of(2020, 2, 12)
        );
        Assertions.assertNotNull(dragMetDynamic);
    }
    @Test
    void test2() throws DatatypeConfigurationException{
        KeyRateResponse.KeyRateResult keyRateResult = cbrClient.getKeyRate(
                LocalDate.of(2020, 1, 11),
                LocalDate.of(2020, 2, 12)
        );
        Assertions.assertNotNull(keyRateResult);
    }
    @Test
    void test3() throws DatatypeConfigurationException{
        GetCursOnDateResponse.GetCursOnDateResult cursOnDateResult = cbrClient.getCursOnDate(
                LocalDate.of(2024, 7, 12)
        );
        Assertions.assertNotNull(cursOnDateResult);
    }
    @Test
    void test4() throws DatatypeConfigurationException{
        RuoniaResponse.RuoniaResult ruoniaResult = cbrClient.getRuonia(
                LocalDate.of(2020, 1, 11),
                LocalDate.of(2020, 2, 12)
        );
        Assertions.assertNotNull(ruoniaResult);
    }
}