package fr.gwombat.fibonacci.resources;

import fr.gwombat.fibonacci.services.FibonacciService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by guillaume.
 *
 * @since 17/08/2018
 */
//@Service
@WebService(serviceName = "fibonacciService", endpointInterface = "fr.gwombat.fibonacci.resources.FibonacciResource")
//@WebService(serviceName = "fibonacciService")
public class SoapFiboEndpoint implements FibonacciResource {

    private FibonacciService fibonacciService;

    @Override
    //@WebMethod(action = "Calculate the Fibonacci's suite value from the given index")
    public long getFibonacciValue(int index) {
        return fibonacciService.fibonacci(index);
    }

    //@Autowired
    public void setFibonacciService(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    public FibonacciService getFibonacciService() {
        return fibonacciService;
    }
}
