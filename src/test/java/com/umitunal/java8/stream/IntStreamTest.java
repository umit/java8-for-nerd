package com.umitunal.java8.stream;

import org.junit.Test;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author: umitunal
 */
public class IntStreamTest {

    @Test
    public void shouldCreateEmptyIntStreams() {
        IntStream empty = IntStream.empty();
        assertThat(empty.count(), is(equalTo(0L)));
    }

    @Test
    public void shouldCreateIntStream() {
        int sum = IntStream.builder().add(10).add(10).add(10).add(10).build().sum();
        assertEquals(40, sum);
    }

    @Test
    public void shouldCreateIntStreamAndFindFirst() {
        OptionalInt first = IntStream.builder().add(10).add(20).add(30).add(40).build().findFirst();
        assertThat(first.getAsInt(), equalTo(10));
    }

    @Test
    public void shouldRangeClosed() {
        List<Integer> numbers = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
        assertThat(numbers, contains(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)));
    }

    @Test
    public void shouldIntStreamToMapIntAndReturnMaxValue() {
        List<String> values = Stream.of("10", "20", "30").collect(Collectors.toList());

        assertThat(values.stream().mapToInt(Integer::parseInt).max().getAsInt(), equalTo(30));
        assertThat(values.stream().mapToInt(Integer::parseInt).min().getAsInt(), equalTo(10));
    }

    @Test
    public void shouldReturnsAnOrderedSequenceWithIncrementOfZero() {
        IntStream s = IntStream.range(0, 10);

        List<Integer> values = s.boxed().collect(Collectors.toList());
        assertThat(values, hasSize(10));
        assertThat(values, hasItems(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void shouldConcatTwoIntStream() {
        IntStream intStream1 = IntStream.builder().add(10).add(20).add(30).add(40).add(50).build();
        IntStream intStream2 = IntStream.builder().add(60).add(70).add(80).add(90).add(100).build();

        IntStream intStream = IntStream.concat(intStream1, intStream2);
        List<Integer> values = intStream.boxed().collect(Collectors.toList());

        assertThat(values, hasSize(10));
        assertThat(values, hasItems(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
    }
}
