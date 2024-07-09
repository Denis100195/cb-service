package ru.financial.data.cbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.financial.data.cbservice.config.CbConfig;

@SpringBootApplication
@EnableConfigurationProperties(CbConfig.class)
public class CbServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CbServiceApplication.class, args);
    }
}
