package ru.financial.data.cbservice.service.parser;

import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ru.financial.data.cbservice.client.CbrClient;
import ru.financial.data.cbservice.entity.CursOnDate;
import ru.financial.data.cbservice.entity.KeyRate;

import javax.xml.datatype.DatatypeConfigurationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CursOnDateParserService {
    private CbrClient cbrClient;
    public CursOnDateParserService(CbrClient cbrClient) {
        this.cbrClient = cbrClient;
    }
    public List<CursOnDate> cursOnDateParse(LocalDate date) throws DatatypeConfigurationException {
        Element element = (Element) cbrClient.getCursOnDate(date).getAny();
        List<CursOnDate> cursOnDateArrList = new ArrayList<>();
        NodeList cursOnDateNodes = element.getElementsByTagName("ValuteCursOnDate");
        for (int i = 0; i < cursOnDateNodes.getLength(); i++){
            NodeList valList = cursOnDateNodes.item(i).getChildNodes();
            CursOnDate curCOD = new CursOnDate(
                    date,
                    valList.item(0).getTextContent(),
                    Long.parseLong(valList.item(1).getTextContent()),
                    Double.parseDouble(valList.item(2).getTextContent()),
                    Integer.parseInt(valList.item(3).getTextContent()),
                    valList.item(4).getTextContent(),
                    Double.parseDouble(valList.item(5).getTextContent())
            );
            cursOnDateArrList.add(curCOD);
        }
        return cursOnDateArrList;
    }

}
