package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Price {

    @Column(name = "regular_price")
    private int regularPrice;

    @Column(name = "discount_rate")
    private double discountRate;

    @Column(name = "sell_price")
    private int sellPrice;

    protected Price() {
    }

    public Price(int regularPrice, double discountRate) {
        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "Price{" +
                "regularPrice=" + regularPrice +
                ", discountRate=" + discountRate +
                '}';
    }
}
