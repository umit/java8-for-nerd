package com.umitunal.java8.date;

import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author: umitunal
 */
public class YearTests {

    @Test
    public void shouldCheckIfLeapYear() {
        Year year1 = Year.of(2000);
        Year year2 = Year.of(2001);

        assertTrue(year1.isLeap());
        assertFalse(year2.isLeap());
    }

    @Test
    public void shouldCheckIsAfterAndBefore() {
        Year year2000 = Year.of(2000);
        Year year2001 = Year.of(2001);

        assertTrue(year2000.isBefore(year2001));
        assertTrue(year2001.isAfter(year2000));
    }
}
