package com.umitunal.java8.functions;

import org.junit.Test;

import java.util.function.*;

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


    @Test
    public void shouldCreateAnIdentityUnaryOperator() {
        UnaryOperator<Integer> op = UnaryOperator.identity();
        assertThat(op.apply(1), is(equalTo(1)));
        assertThat(op.apply(99), is(equalTo(99)));
    }

    @Test
    public void shouldCreateFunctionsWithOneArgument() {
        Function<String, String> upperFun = String::toUpperCase;
        assertThat(upperFun.apply("home"), is(equalTo("HOME")));
    }

    @Test
    public void shouldCreateBinaryOperations() {
        BinaryOperator<Integer> sumFun = (a, b) -> a + b;
        assertThat(sumFun.apply(1, 2), is(equalTo(3)));
    }

    @Test
    public void shouldCreateFunctionsWithTwoArguments() {
        BiFunction<Integer, Integer, Integer> sumFun = (a, b) -> a + b;
        assertThat(sumFun.apply(1, 2), is(equalTo(3)));
    }

    @Test
    public void shouldCreatePredicates() {
        Predicate<String> longString = s -> s.length() > 10;
        assertThat(longString.test("hello"), is(equalTo(false)));
        assertThat(longString.test("hello world"), is(equalTo(true)));
    }

    @Test
    public void shouldComposePredicates() {
        Predicate<String> longString = s -> s.length() > 100;
        Predicate<String> startsWithHello = s -> s.startsWith("hello");

        Predicate<String> longAndStartsWithHello = longString.or(startsWithHello);
        assertThat(longAndStartsWithHello.test("hello world"), is(true));
    }

    @Test
    public void shouldUseLazyEvaluationForLogicalANDForPredicates() {
        Predicate<String> longString = s -> s.length() > 100;
        Predicate<String> neverEvaluated = s -> { throw new RuntimeException("Not called");};

        boolean res = longString.and(neverEvaluated).test("hello");
        assertThat(res, is(false));
    }

    @Test
    public void shouldNegatePredicates() {
        Predicate<String> longString = s -> s.length() > 10;
        Predicate<String> shortString = longString.negate();
        assertThat(shortString.test("hello"), is(true));
    }

    @Test
    public void shouldSupplyValues() {
        Supplier<String> supplier = () -> "hello";
        assertThat(supplier.get(), is(equalTo("hello")));
        assertThat(supplier.get(), is(equalTo("hello")));
    }

}
