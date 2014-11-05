package com.umitunal.java8.date;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author: umitunal
 */
public class DayOfWeekTests {

    @Test
    public void shouldReturnInformationAboutDayOfWeek() {
        DayOfWeek dayOfWeek = LocalDate.of(1989, 3, 13).getDayOfWeek();

        assertThat(dayOfWeek, is(equalTo(MONDAY)));
        assertThat(dayOfWeek.getValue(), is(equalTo(1)));
        assertThat(dayOfWeek.name(), is(equalTo(MONDAY.name())));
    }

    @Test
    public void shouldCreateInstanceOfDayOfWeekFromName() {
        DayOfWeek day = DayOfWeek.valueOf("FRIDAY");
        assertThat(day, is(equalTo(FRIDAY)));
    }

    @Test
    public void shouldGetTheDayOfWeekNumber() {
        assertThat(FRIDAY.getValue(), is(equalTo(5)));
    }

    @Test
    public void shouldCalculateMinusDate() {
        assertThat(FRIDAY.minus(2), is(equalTo(DayOfWeek.WEDNESDAY)));
    }
}
