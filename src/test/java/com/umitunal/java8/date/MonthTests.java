package com.umitunal.java8.date;

import org.junit.Test;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author: umitunal
 */
public class MonthTests {

    private Locale TR_LOCALE = new Locale("tr", "TR");

    @Test
    public void shouldGetLocalizedDisplayNameForMonths() {

        Month month = Month.MARCH;

        assertThat(month.getDisplayName(TextStyle.FULL, TR_LOCALE), equalTo("Mart"));
        assertThat(month.getDisplayName(TextStyle.FULL_STANDALONE, TR_LOCALE), equalTo("Mart"));

        assertThat(month.getDisplayName(TextStyle.SHORT, TR_LOCALE), equalTo("Mar"));
        assertThat(month.getDisplayName(TextStyle.SHORT_STANDALONE, TR_LOCALE), equalTo("Mar"));

        assertThat(month.getDisplayName(TextStyle.NARROW, TR_LOCALE), equalTo("M"));
    }

    @Test
    public void shouldReturnMonthInformation() {
        Month month = Month.MARCH;

        assertThat(month.getValue(), equalTo(3));
        assertThat(month.minLength(), equalTo(31));
        assertThat(month.maxLength(), equalTo(31));
    }

    @Test
    public void shouldReturnMonthFromNumber() {
        Month march = Month.of(3);
        assertThat(march, is(equalTo(Month.MARCH)));
    }

    @Test
    public void shouldAddMonths() {
        Month march = Month.of(3);
        assertThat(march.plus(10), equalTo(Month.JANUARY));
    }

    @Test
    public void shouldMinusMonths() {
        Month march = Month.of(3);
        assertThat(march.minus(3), equalTo(Month.DECEMBER));
    }
}
