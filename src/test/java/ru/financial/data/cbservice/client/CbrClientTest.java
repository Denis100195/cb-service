package ru.financial.data.cbservice.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cbr.web.DragMetDynamicResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;

@SpringBootTest
class CbrClientTest {

    @Autowired
    CbrClient cbrClient;

    @Test
    void test() throws DatatypeConfigurationException {
        DragMetDynamicResponse.DragMetDynamicResult dragMetDynamic = cbrClient.getDragMetDynamic(
                LocalDate.of(2020, 1, 11),
                LocalDate.of(2020, 2, 12)
        );
        Assertions.assertNotNull(dragMetDynamic);
    }
}