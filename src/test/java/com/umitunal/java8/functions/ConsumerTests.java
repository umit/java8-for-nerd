package com.umitunal.java8.functions;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author: umitunal
 */
public class ConsumerTests {


    @Test
    public void shouldConsumerAppendHelloWorld() {
        Consumer<StringBuilder> stringBuilderConsumer = sb -> sb.append("world");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello ");

        stringBuilderConsumer.accept(stringBuilder);

        assertThat(stringBuilder.toString(), is(equalTo("Hello world")));

    }

    @Test
    public void shouldBiConsumerAppendHelloWorld() throws Exception {
        BiConsumer<StringBuilder, String> stringBuilderStringBiConsumer = (sb, s) -> sb.append(s);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilderStringBiConsumer.accept(stringBuilder, "Hello world");

        assertThat(stringBuilder.toString(), is(equalTo("Hello world")));
    }

    @Test
    public void shouldConsumeTwoConsumers() {

        BiConsumer<StringBuilder, String> consumer = (sb, s) -> sb.append(s);

        StringBuilder stringBuilder = new StringBuilder();
        consumer.andThen((sbl, s) -> sbl.append(s.toUpperCase())).accept(stringBuilder, "hello");

        assertThat(stringBuilder.toString(), equalTo("helloHELLO"));

    }
}
