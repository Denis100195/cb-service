package ru.financial.data.cbservice.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.cbr.web.DailyInfoSoap;
import ru.cbr.web.DragMetDynamicResponse;
import ru.financial.data.cbservice.config.CbConfig;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

@Service
public class CbrClient extends BaseClient{

    public DailyInfoSoap wsClient;

    public CbrClient(CbConfig cbConfig){
        wsClient = createWSClient(DailyInfoSoap.class,
                cbConfig.cbrWsdl,
                cbConfig.cbrConnTmt,
                cbConfig.cbrReadTmt,
                getCustomFeatures());
    }
    public DragMetDynamicResponse.DragMetDynamicResult getDragMetDynamic(String fromDate, String toDate) throws DatatypeConfigurationException {
        XMLGregorianCalendar frDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.parse(fromDate).toString());
        XMLGregorianCalendar tDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.parse(toDate).toString());
        DragMetDynamicResponse.DragMetDynamicResult dragMetDynamicResult = wsClient.dragMetDynamic(frDate, tDate);
        return dragMetDynamicResult;
    }

}
