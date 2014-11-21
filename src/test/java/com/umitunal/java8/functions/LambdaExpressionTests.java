package com.umitunal.java8.functions;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author: umitunal
 */
public class LambdaExpressionTests {

    @Test
    public void shouldDefinePredicateAsInterfaces() {
        MyPredicate<String> p = s -> s.length() > 5;
        assertThat(p.apply("123456"), is(true));
        assertThat(p.apply("1234"), is(false));
    }

    @Test
    public void shouldDefineFunctionsAsInterfaces() {
        MyFunction<String, String, Integer> f = (s1, s2) -> s1.length() + s2.length();
        assertThat(f.apply("abc", "def"), is(equalTo(6)));
    }

    @Test
    public void shouldLambdaExpressionsBeClosures() {
        int a = 10;
        MyFunction<Integer, Integer, Integer> op = (n1, n2) -> a + (n1 * n2);

        assertThat(op.apply(2, 3), is(equalTo(16)));
    }

    @Test
    public void shouldUseMethodReferencesToReplaceFunctionalInterfaces() {
        assertThat(TestClass.applyPredicate(TestClass::method, "abc"), is(true));
    }


    @FunctionalInterface
    private static interface MyPredicate<T> {
        boolean apply(T t);
    }


    @FunctionalInterface
    private static interface MyFunction<A, B, R> {
        R apply(A a, B b);
    }


    private static class TestClass {

        static <T> boolean applyPredicate(MyPredicate<T> p, T t) {
            return p.apply(t);
        }

        static int applyFunction(MyFunction<String, String, Integer> fun, String a, String b) {
            return fun.apply(a, b);
        }

        static boolean method(String s) {
            return s.equals(s);
        }
    }
}
