package com.umitunal.java8.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;

/**
 * @author: umitunal
 */
public class Product implements Serializable {

    private static final long serialVersionUID = -1824650413296132164L;

    public static final Comparator<Product> PRICE_ASC = Comparator.comparing(Product::getPrice);

    private Long id;

    private String title;

    private BigDecimal price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product id(final Long id) {
        this.id = id;
        return this;
    }

    public Product title(final String title) {
        this.title = title;
        return this;
    }

    public Product price(final BigDecimal price) {
        this.price = price;
        return this;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return new EqualsBuilder()
                .append(this.id, product.id)
                .append(this.title, product.title)
                .append(this.price, product.price)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(title)
                .append(price)
                .toHashCode();
    }
}
