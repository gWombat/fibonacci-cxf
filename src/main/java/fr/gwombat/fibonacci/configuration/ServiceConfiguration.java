package fr.gwombat.fibonacci.configuration;

import fr.gwombat.fibonacci.resources.FibonacciResource;
import fr.gwombat.fibonacci.resources.SoapFiboEndpoint;
import fr.gwombat.fibonacci.services.FibonacciService;
import fr.gwombat.fibonacci.services.impl.FibonacciServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.xml.ws.Endpoint;

/**
 * https://stackoverflow.com/a/36137189/5695673
 * http://www.baeldung.com/apache-cxf-with-spring
 */
@Configuration
public class ServiceConfiguration {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    @Primary
    public FibonacciService fibonacciService() {
        return new FibonacciServiceImpl();
    }

    @Bean
    public FibonacciResource soapFibonacciEndpoint(){
        SoapFiboEndpoint endpoint = new SoapFiboEndpoint();
        endpoint.setFibonacciService(fibonacciService());
        return endpoint;
    }

    @Bean
    public Endpoint endpoint() {
        //EndpointImpl endpoint = new EndpointImpl(springBus(), fibonacciService());
        EndpointImpl endpoint = new EndpointImpl(springBus(), soapFibonacciEndpoint());
        endpoint.publish("/soap/fibonacci");
        return endpoint;
    }
}

