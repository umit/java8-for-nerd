package com.umitunal.java8.date;

import org.junit.Test;

import java.time.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author: umitunal
 */
public class DateAndTimeTests {

    private LocalDate MARCH_13TH = LocalDate.of(1989, 3, 13);

    @Test
    public void shouldCreateNewLocalDates() {
        LocalDate d1 = LocalDate.of(1989, 3, 13);
        LocalDate d2 = LocalDate.of(1989, Month.MARCH, 13);
        assertThat(d1, is(equalTo(d2)));
    }

    @Test
    public void shouldProduceISORepresentationAsString() {
        LocalDate date = LocalDate.of(2014, Month.JULY, 4);
        LocalTime time = LocalTime.of(13, 30, 13);
        assertThat(date.toString(), is(equalTo("2014-07-04")));
        assertThat(time.toString(), is(equalTo("13:30:13")));
    }

    @Test
    public void shouldGetYearMonthAndDayFromLocalDate() {
        assertThat(MARCH_13TH.getDayOfMonth(), is(equalTo(13)));
        assertThat(MARCH_13TH.getMonth(), is(equalTo(Month.MARCH)));
        assertThat(MARCH_13TH.getYear(), is(equalTo(1989)));
    }

    @Test
    public void shouldGetTheDayOfWeekFromLocalDate() {
        assertThat(MARCH_13TH.getDayOfWeek(), is(equalTo(DayOfWeek.MONDAY)));
    }

    @Test
    public void shouldGetTheDayOfYearFromLocalDate() {
        assertThat(MARCH_13TH.getDayOfYear(), is(equalTo(72)));
    }

    @Test
    public void shouldGetTheDayOfMonthFromLocalDate() throws Exception {
        assertThat(MARCH_13TH.getDayOfMonth(), is(equalTo(13)));
    }

    @Test
    public void shouldCreateNewLocalDateFromYearAndDayOfYear() {
        LocalDate date = LocalDate.ofYearDay(2015, 72);
        assertThat(date.toString(), is(equalTo("2015-03-13")));
        assertThat(date.getDayOfYear(), is(equalTo(72)));
    }

    @Test
    public void shouldChangeDayMonthAndYearForGivenLocalDate() {
        LocalDate localDate = LocalDate.now().withDayOfMonth(13).withMonth(3).withYear(1989);

        assertThat(localDate.getDayOfMonth(), is(equalTo(13)));
        assertThat(localDate.getMonthValue(), is(equalTo(3)));
        assertThat(localDate.getYear(), is(equalTo(1989)));
    }

    @Test
    public void shouldCreateLocalTimeFromHourAndMinutes() {
        LocalTime time = LocalTime.of(12, 30);
        assertThat(time.getHour(), is(equalTo(12)));
        assertThat(time.getMinute(), is(equalTo(30)));
        assertThat(time.getSecond(), is(equalTo(0)));
    }

    @Test
    public void shouldCreateLocalTimeFromHoursMinutesAndSeconds() {
        LocalTime time = LocalTime.of(12, 30, 15);
        assertThat(time.getHour(), is(equalTo(12)));
        assertThat(time.getMinute(), is(equalTo(30)));
        assertThat(time.getSecond(), is(equalTo(15)));
    }

    @Test
    public void shouldCreateLocalTimeFromSecondOfDay() {
        LocalTime time = LocalTime.ofSecondOfDay(12_345);
        assertThat(time, is(LocalTime.of(3, 25, 45)));
    }

    @Test
    public void shouldCreateLocalDateTimeFromLocalTime() {
        LocalDateTime ldt = LocalTime.NOON.atDate(LocalDate.of(1989, 3, 13));
        assertThat(ldt.toLocalDate(), is(equalTo(MARCH_13TH)));
        assertThat(ldt.toLocalTime(), is(equalTo(LocalTime.NOON)));
    }

    @Test
    public void shouldCreateLocalDateTimeFromLocalDate() {
        LocalDateTime ldt = MARCH_13TH.atTime(LocalTime.NOON);
        assertThat(ldt.toLocalDate(), is(equalTo(MARCH_13TH)));
        assertThat(ldt.toLocalTime(), is(equalTo(LocalTime.NOON)));
    }
}
