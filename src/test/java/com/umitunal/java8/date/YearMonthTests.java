package com.umitunal.java8.date;

import org.junit.Test;

import java.time.Month;
import java.time.YearMonth;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author: umitunal
 */
public class YearMonthTests {

    @Test
    public void shouldCreateNewYearMonths() {
        YearMonth november1 = YearMonth.of(2014, 11);
        YearMonth november2 = YearMonth.of(2014, Month.NOVEMBER);
        assertThat(november1, is(equalTo(november2)));
    }

    @Test
    public void shouldGetYearAndMonth() {
        YearMonth november = YearMonth.of(2014, 11);
        assertThat(november.getYear(), is(equalTo(2014)));
        assertThat(november.getMonth(), is(equalTo(Month.NOVEMBER)));
    }

    @Test
    public void shouldGetLengthOfMonths() {
        YearMonth november = YearMonth.of(2014, 11);
        YearMonth june = YearMonth.of(2014, Month.JUNE);
        assertThat(november.lengthOfMonth(), is(equalTo(30)));
        assertThat(june.lengthOfMonth(), is(equalTo(30)));
    }
}
