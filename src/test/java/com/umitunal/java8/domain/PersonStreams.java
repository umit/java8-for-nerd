package com.umitunal.java8.domain;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.umitunal.java8.domain.Person.Gender.FEMALE;
import static com.umitunal.java8.domain.Person.Gender.MALE;

/**
 * @author: umitunal
 */
public class PersonStreams {

    public static List<Person> persons() {
        Person ken = new Person(1, "Ken", MALE, LocalDate.of(1970, Month.MAY, 4), 6000.0);
        Person jeff = new Person(2, "Jeff", MALE, LocalDate.of(1970, Month.JULY, 15), 7100.0);
        Person donna = new Person(3, "Donna", FEMALE, LocalDate.of(1962, Month.JULY, 29), 8700.0);
        Person chris = new Person(4, "Chris", MALE, LocalDate.of(1993, Month.DECEMBER, 16), 1800.0);
        Person laynie = new Person(5, "Laynie", FEMALE, LocalDate.of(2012, Month.DECEMBER, 13), 0.0);
        Person lee = new Person(6, "Li", MALE, LocalDate.of(2001, Month.MAY, 9), 2400.0);

        List<Person> persons = Arrays.asList(ken, jeff, donna, chris, laynie, lee);

        return persons;
    }

    public static Stream<Person> personStream() {
        return persons().stream();
    }

}

