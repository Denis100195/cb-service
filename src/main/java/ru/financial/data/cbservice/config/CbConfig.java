package ru.financial.data.cbservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CbConfig {

    @Value("${cbr.wsdl}")
    public String cbrWsdl;

    @Value("${cbr.timeout.connection}")
    public int cbrConnTmt;

    @Value("${cbr.timeout.read}")
    public int cbrReadTmt;
}
