package com.umitunal.java8.functions;

import com.umitunal.java8.domain.Product;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * @author: umitunal
 */
public class BinaryOperatorTests {

    Product product1 = new Product().id(10L).title("iPhone 5").price(BigDecimal.ONE);
    Product product2 = new Product().id(11L).title("iPhone 5s").price(BigDecimal.TEN);

    @Test
    public void shouldApplyBinaryOperator() {
        BinaryOperator<Product> operator = (p1, p2) -> p1;

        Product firstProduct = operator.apply(product1, product2);

        assertThat(firstProduct.getId(), is(equalTo(10L)));
    }

    @Test
    public void shouldReturnProductByMinimumPrice() {

        Product product1 = new Product().id(10L).title("iPhone 5").price(BigDecimal.ONE);
        Product product2 = new Product().id(11L).title("iPhone 5s").price(BigDecimal.TEN);

        BinaryOperator<Product> operator = BinaryOperator.minBy(Product.PRICE_ASC);

        Product product = operator.apply(product1, product2);

        assertThat(product, is(equalTo(product1)));
    }

    @Test
    public void shouldReturnProductByMaximumPrice() {
        BinaryOperator<Product> operator = BinaryOperator.maxBy(Product.PRICE_ASC);

        Product product = operator.apply(product1, product2);

        assertThat(product, is(equalTo(product2)));
    }


    @Test
    public void shouldApplyBinaryOperatorAndThenFunction() {

        BinaryOperator<Product> operator = BinaryOperator.maxBy(Product.PRICE_ASC);

        Function<Product, Boolean> priceFunction = p -> p.getPrice().compareTo(BigDecimal.TEN) > 0;

        BiFunction<Product, Product, Boolean> productAndThenFunction = operator.andThen(priceFunction);

        assertFalse(productAndThenFunction.apply(product1, product2));
    }
}
