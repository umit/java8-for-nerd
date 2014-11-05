package com.umitunal.java8.functions;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author: umitunal
 */
public class FunctionalInterfaceTests {

    @FunctionalInterface
    interface MathFunctionInterface {
        public int calculate(int number1, int number2);
    }

    @FunctionalInterface
    interface GenericMathFunctionInterface<T, U, R> {
        public R apply(T t, U u);
    }


    @Test
    public void shouldSumTwoNumbers() {
        MathFunctionInterface sum = (x, y) -> x + y;

        int calculate = sum.calculate(1, 2);

        assertThat(calculate, equalTo(3));
    }

    @Test
    public void shouldSumTwoNumbersFromGenericMathFunction() {
        GenericMathFunctionInterface<Integer, Integer, String> sum = (number1, number2) -> String.valueOf(number1 + number2);

        String calculatedStringValue = sum.apply(1, 2);

        assertThat(calculatedStringValue, is(equalTo("3")));
    }
}
