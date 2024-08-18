package ru.financial.data.cbservice.service.parser;

import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ru.financial.data.cbservice.client.CbrClient;
import ru.financial.data.cbservice.entity.Ruonia;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RuoniaParserService {
    private CbrClient cbrClient;
    public RuoniaParserService (CbrClient cbrClient){
        this.cbrClient = cbrClient;
    }
    public List<Ruonia> ruoniaParse(LocalDate fromDate, LocalDate toDate) throws DatatypeConfigurationException {
        Element element = (Element) cbrClient.getRuonia(fromDate, toDate).getAny();
        List<Ruonia> ruoniaArrList = new ArrayList<>();

        NodeList ruoniaList = element.getElementsByTagName("ro");
        for (int i = 0; i < ruoniaList.getLength(); i++){
            NodeList valList = ruoniaList.item(i).getChildNodes();
            Ruonia curRuo = new Ruonia(
                    LocalDate.parse(valList.item(0).getTextContent().substring(0, 10)),
                    Double.parseDouble(valList.item(1).getTextContent()),
                    Double.parseDouble(valList.item(2).getTextContent()),
                    LocalDate.parse(valList.item(3).getTextContent().substring(0, 10))
            );
            ruoniaArrList.add(curRuo);
        }
        return ruoniaArrList;
    }
}
