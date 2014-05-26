package com.umitunal.java8.stream;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

/**
 * @author : umitunal
 */
public class StreamTests {


    @Test
    public void shouldCheckWhetherAllElementsMatchThePredicate() {
        assertThat(numbers().allMatch(n -> n < 100), is(equalTo(true)));
        assertThat(numbers().allMatch(n -> n % 2 == 0), is(equalTo(false)));
    }

    private Stream<Integer> numbers() {
        return Stream.of(1, 10, 20, 30, 40, 50, 55);
    }

    @Test
    public void shouldConcatTwoStreams() {
        Stream<Integer> s1 = Stream.of(10, 20, 30, 40);
        Stream<Integer> s2 = Stream.of(50, 60, 70, 80);

        Stream<Integer> s = Stream.concat(s1, s2);

        List<Integer> values = s.collect(Collectors.toList());
        assertThat(values.size(), is(equalTo(8)));
        assertThat(values, contains(10, 20, 30, 40, 50, 60, 70, 80));
    }

    @Test
    public void shouldCreateStreamsWithOnlyOneElement() {
        Stream<Integer> s = Stream.of(1);
        assertThat(s.count(), is(equalTo(1L)));
    }

    @Test
    public void shouldCreateStreamsWithTheSpecifiedElements() {
        Stream<Integer> s = Stream.of(1, 2, 3, 4);
        List<Integer> elems = s.collect(Collectors.toList());
        assertThat(elems, contains(1, 2, 3, 4));
    }

    @Test
    public void shouldCreateArraysWithStreamElements() {
        Integer[] arr = Stream.of(1, 2, 3, 4).toArray(Integer[]::new);
        assertThat(arr, is(new Integer[]{1, 2, 3, 4}));
    }

    @Test
    public void shouldGenerateInfiniteStreams() {
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);
        int val = infiniteStream.skip(100)
                                .limit(1)
                                .findFirst()
                                .orElse(-1);

        assertThat(val, is(equalTo(100)));
    }

    @Test
    public void shouldApplyFunctionToStreamElements() {
        String[] upperStrings = Stream.of("I", "am", "nerd")
                .map(String::toUpperCase)
                .toArray(String[]::new);

        assertThat(upperStrings, is(new String[]{"I", "AM", "NERD"}));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowsExceptionConsumingStreamsAfterATerminalOperation() {
        Stream<Integer> s = Stream.of(1, 4, 43, 56, 59);
        s.count();

        s.distinct();
    }

    @Test
    public void shouldFilterOutNullValuesFromStreams() {
        List<String> cities = Arrays.asList("istanbul", null, null, "ankara", "izmir");
        long nullCount = cities.stream().filter(Objects::isNull).count();
        assertThat(nullCount, is(equalTo(2L)));
    }

    @Test
    public void shouldFilterOutNonNullValuesFromStreams() {
        List<String> names = Arrays.asList("one", null, null, "four", "five");

        long nonNullCount = names.stream()
                .filter(Objects::nonNull)
                .count();

        assertThat(nonNullCount, is(equalTo(3L)));
    }
}
