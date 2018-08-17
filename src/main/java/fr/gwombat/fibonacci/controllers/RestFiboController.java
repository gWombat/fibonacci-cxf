package fr.gwombat.fibonacci.controllers;

import fr.gwombat.fibonacci.resources.FibonacciResource;
import fr.gwombat.fibonacci.services.FibonacciService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guillaume.
 *
 * @since 16/08/2018
 */
@RestController
@RequestMapping("/rest/fibonacci")
public class RestFiboController implements FibonacciResource {

    private final FibonacciService fibonacciService;

    public RestFiboController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/{index}")
    public long getFibonacciValue(@PathVariable("index") int index) {
        return fibonacciService.fibonacci(index);
    }
}
