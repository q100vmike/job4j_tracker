package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenQuadFunctionThenQuadResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 5, x -> 1 * Math.pow(x, 2) + 2 * x + 3);
        List<Double> expected = Arrays.asList(6D, 11D, 18D, 27D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExpFunctionThenExpResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(3, 7, x -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(125D, 625D, 3125D, 15625D);
        assertThat(result).containsAll(expected);
    }
}