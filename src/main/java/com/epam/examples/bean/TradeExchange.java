package com.epam.examples.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TradeExchange {
    private double buyCoefficientForEuro;
    private double buyCoefficientForDollar;
    private double sellCoefficientForEuro;
    private double sellCoefficientForDollar;
    private List<Person> persons;

    public TradeExchange(double buyCoefficientForEuro, double buyCoefficientForDollar, double sellCoefficientForEuro, double sellCoefficientForDollar) {
        this.buyCoefficientForEuro = buyCoefficientForEuro;
        this.buyCoefficientForDollar = buyCoefficientForDollar;
        this.sellCoefficientForEuro = sellCoefficientForEuro;
        this.sellCoefficientForDollar = sellCoefficientForDollar;
        persons = new LinkedList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public double getBuyCoefficientForEuro() {
        return buyCoefficientForEuro;
    }

    public void setBuyCoefficientForEuro(double buyCoefficientForEuro) {
        this.buyCoefficientForEuro = buyCoefficientForEuro;
    }

    public double getBuyCoefficientForDollar() {
        return buyCoefficientForDollar;
    }

    public void setBuyCoefficientForDollar(double buyCoefficientForDollar) {
        this.buyCoefficientForDollar = buyCoefficientForDollar;
    }

    public double getSellCoefficientForEuro() {
        return sellCoefficientForEuro;
    }

    public void setSellCoefficientForEuro(double sellCoefficientForEuro) {
        this.sellCoefficientForEuro = sellCoefficientForEuro;
    }

    public double getSellCoefficientForDollar() {
        return sellCoefficientForDollar;
    }

    public void setSellCoefficientForDollar(double sellCoefficientForDollar) {
        this.sellCoefficientForDollar = sellCoefficientForDollar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeExchange exchange = (TradeExchange) o;
        return Double.compare(exchange.buyCoefficientForEuro, buyCoefficientForEuro) == 0 &&
                Double.compare(exchange.buyCoefficientForDollar, buyCoefficientForDollar) == 0 &&
                Double.compare(exchange.sellCoefficientForEuro, sellCoefficientForEuro) == 0 &&
                Double.compare(exchange.sellCoefficientForDollar, sellCoefficientForDollar) == 0 &&
                Objects.equals(persons, exchange.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyCoefficientForEuro, buyCoefficientForDollar, sellCoefficientForEuro, sellCoefficientForDollar, persons);
    }

    @Override
    public String toString() {
        return "TradeExchange{" +
                "buyCoefficientForEuro=" + buyCoefficientForEuro +
                ", buyCoefficientForDollar=" + buyCoefficientForDollar +
                ", sellCoefficientForEuro=" + sellCoefficientForEuro +
                ", sellCoefficientForDollar=" + sellCoefficientForDollar +
                ", persons=" + persons +
                '}';
    }
}
