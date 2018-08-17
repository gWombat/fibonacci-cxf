package fr.gwombat.fibonacci.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

//@WebService
public interface FibonacciService {

    //@WebMethod(action = "Calculate the Fibonacci's suite value from the given index")
    long fibonacci(@WebParam(name = "index") int value);
}
