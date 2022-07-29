package com.iontrading.practice.functionCalls;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by divya.gupta on 01-08-2018.
 */
public class Trade {

    private String id;
    private String verb;
    private BigDecimal price;
    private Double quantity;

    public Trade() {
    }

    public Trade(String verb, BigDecimal price, Double quantity) {
        this.verb = verb;
        this.price = price;
        this.quantity = quantity;
        this.id = String.valueOf((new Random()).nextInt(151));
    }

    public Trade(String id, String verb, BigDecimal price, Double quantity) {
        this.id = id;
        this.verb = verb;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }


}
