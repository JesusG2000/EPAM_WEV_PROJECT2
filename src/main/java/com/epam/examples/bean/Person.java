package com.epam.examples.bean;

import java.util.Objects;

public class Person {
    private String name;
    private double euro;
    private double dollars;
    private double belCash;


    public Person(String name, double euro, double dollars, double belCash) {
        this.name = name;
        this.euro = euro;
        this.dollars = dollars;
        this.belCash = belCash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEuro() {
        return euro;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public double getDollars() {
        return dollars;
    }

    public void setDollars(double dollars) {
        this.dollars = dollars;
    }

    public double getBelCash() {
        return belCash;
    }

    public void setBelCash(double belCash) {
        this.belCash = belCash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.euro, euro) == 0 &&
                Double.compare(person.dollars, dollars) == 0 &&
                Double.compare(person.belCash, belCash) == 0 &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, euro, dollars, belCash);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", euro=" + euro +
                ", dollars=" + dollars +
                ", belCash=" + belCash +
                '}';
    }
}
