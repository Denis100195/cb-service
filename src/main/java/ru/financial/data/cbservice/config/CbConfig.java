package ru.financial.data.cbservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cbr")
public class CbConfig {
    private String wsdl;
    private int connection;
    private int read;
    public String getWsdl() {
        return wsdl;
    }
    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }
    public int getConnection() {
        return connection;
    }
    public void setConnection(int connection) {
        this.connection = connection;
    }
    public int getRead() {
        return read;
    }
    public void setRead(int read) {
        this.read = read;
    }
}
