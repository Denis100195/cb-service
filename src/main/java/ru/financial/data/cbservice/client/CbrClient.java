package ru.financial.data.cbservice.client;


import org.springframework.stereotype.Service;
import ru.cbr.web.*;
import ru.financial.data.cbservice.config.CbConfig;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

@Service
public class CbrClient extends BaseClient{

    public DailyInfoSoap wsClient;
    public CbrClient(CbConfig cbConfig){
        wsClient = createWSClient(DailyInfoSoap.class,
                cbConfig.getWsdl(),
                cbConfig.getConnection(),
                cbConfig.getRead(),
                getCustomFeatures());
    }
    private static XMLGregorianCalendar toXGC(LocalDate date) throws DatatypeConfigurationException {
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();

        xmlGregorianCalendar.setYear(date.getYear());
        xmlGregorianCalendar.setMonth(date.getMonthValue());
        xmlGregorianCalendar.setDay(date.getDayOfMonth());
        xmlGregorianCalendar.setTime(0,0,0);
        xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        return xmlGregorianCalendar;
    }
    public DragMetDynamicResponse.DragMetDynamicResult getDragMetDynamic(LocalDate fromDate, LocalDate toDate) throws DatatypeConfigurationException {
        DragMetDynamicResponse.DragMetDynamicResult dragMetDynamicResult = wsClient.dragMetDynamic(
                CbrClient.toXGC(fromDate),
                CbrClient.toXGC(toDate)
        );
        return dragMetDynamicResult;
    }
    public KeyRateResponse.KeyRateResult getKeyRate(LocalDate fromDate, LocalDate toDate) throws DatatypeConfigurationException {
        KeyRateResponse.KeyRateResult keyRateResult = wsClient.keyRate(
                CbrClient.toXGC(fromDate),
                CbrClient.toXGC(toDate)
    );
        return keyRateResult;
    }
    public GetCursOnDateResponse.GetCursOnDateResult getCursOnDate(LocalDate localDate) throws DatatypeConfigurationException {
        GetCursOnDateResponse.GetCursOnDateResult cursOnDateResult = wsClient.getCursOnDate(
                CbrClient.toXGC(localDate)
        );
        return cursOnDateResult;
    }
    public RuoniaResponse.RuoniaResult getRuonia(LocalDate fromDate, LocalDate toDate) throws DatatypeConfigurationException{
        RuoniaResponse.RuoniaResult ruoniaResult = wsClient.ruonia(
                CbrClient.toXGC(fromDate),
                CbrClient.toXGC(toDate)
        );
        return ruoniaResult;
    }


}
