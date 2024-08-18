package ru.financial.data.cbservice.service.parser;

import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ru.financial.data.cbservice.client.CbrClient;
import ru.financial.data.cbservice.entity.KeyRate;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class KeyRateParserService {
    private CbrClient cbrClient;
    public KeyRateParserService (CbrClient cbrClient){
        this.cbrClient = cbrClient;
    }
    public List<KeyRate> keyRateParse(LocalDate fromDate, LocalDate toDate) throws DatatypeConfigurationException {
        Element element = (Element) cbrClient.getKeyRate(fromDate, toDate).getAny();
        List<KeyRate> keyRateArrList = new ArrayList<>();
        NodeList keyRateList = element.getElementsByTagName("KR");
        for (int i = 0; i < keyRateList.getLength(); i++){
            NodeList valList = keyRateList.item(i).getChildNodes();
            KeyRate curKR = new KeyRate(
                    LocalDate.parse(valList.item(0).getTextContent().substring(0, 10)),
                    Double.parseDouble(valList.item(1).getTextContent())
            );
            keyRateArrList.add(curKR);
        }
        return keyRateArrList;
    }
}
