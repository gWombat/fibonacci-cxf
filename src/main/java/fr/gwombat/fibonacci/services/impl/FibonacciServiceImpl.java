package fr.gwombat.fibonacci.services.impl;

import fr.gwombat.fibonacci.services.FibonacciService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebService(serviceName = "fibonacciService", endpointInterface = "fr.gwombat.fibonacci.services.FibonacciService")
public class FibonacciServiceImpl implements FibonacciService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciServiceImpl.class);

    private static final Map<Integer, Long> STORED_VALUES = new ConcurrentHashMap<>(0);


    @Override
    public long fibonacci(int value) {
        long result = calculate(value);
        STORED_VALUES.put(value, result);
        LOGGER.debug("Storing value {}", result);
        return result;
    }

    private long calculate(int value) {
        if ((value == 0) || (value == 1))
            return value;
        else if (STORED_VALUES.get(value) != null) {
            LOGGER.debug("Retrieving value {} from cache", STORED_VALUES.get(value));
            return STORED_VALUES.get(value);
        } else
            return calculate(value - 1) + calculate(value - 2);
    }
}
