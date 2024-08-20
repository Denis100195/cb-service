package ru.financial.data.cbservice.client;

import jakarta.xml.ws.BindingProvider;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
/*Класс для получения методов для работы с ЦБ*/
public abstract class BaseClient {
    protected <T> T createWSClient(Class<T> portType,
                                   String url,
                                   int connectionTimeout,
                                   int readTimeout,
                                   List<Feature> features) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(portType);
        factory.setAddress(url);

        for (Feature feature : features) {
            factory.getFeatures().add(feature);
        }
        T service = portType.cast(factory.create());
        ((BindingProvider) service).getRequestContext().put("javax.xml.ws.client.connectionTimeout", connectionTimeout);
        ((BindingProvider) service).getRequestContext().put("javax.xml.ws.client.receiveTimeout", readTimeout);
        ((BindingProvider) service).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", readTimeout); // Timeout in millis
        ((BindingProvider) service).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", connectionTimeout);
        Client client = ClientProxy.getClient(service);
        ((ClientImpl) client).setSynchronousTimeout(readTimeout);
        setTimeouts(client, Duration.ofMillis(readTimeout));
        return service;
    }
    private void setTimeouts(Client client, Duration timeout) {
        HTTPConduit http = (HTTPConduit) client.getConduit();
        HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(timeout.toMillis());
        policy.setReceiveTimeout(timeout.toMillis());
        policy.setConnectionRequestTimeout(timeout.toMillis());
        policy.setAllowChunking(false);
        http.setClient(policy);
    }
    protected List<Feature> getCustomFeatures() {
        LoggingFeature loggingFeature = new LoggingFeature();
        loggingFeature.setPrettyLogging(true);
        loggingFeature.setVerbose(true);
        loggingFeature.setLogMultipart(true);
        return Collections.singletonList(loggingFeature);
    }
}
