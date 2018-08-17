package fr.gwombat.fibonacci.resources;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by guillaume.
 *
 * @since 17/08/2018
 */
@WebService
public interface FibonacciResource {

    @WebMethod(action = "Calculate the Fibonacci's suite value from the given index")
    long getFibonacciValue(int index);

}
