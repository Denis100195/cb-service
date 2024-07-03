package ru.financial.data.cbservice.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cbr.web.DragMetDynamicResponse;

import javax.xml.datatype.DatatypeConfigurationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CbrClientTest {

    @Autowired
    CbrClient cbrClient;

    @Test
    void test() throws DatatypeConfigurationException {
        DragMetDynamicResponse.DragMetDynamicResult dragMetDynamic = cbrClient.getDragMetDynamic("2020-02-10", "2021-09-19");
        System.out.println();
    }

}