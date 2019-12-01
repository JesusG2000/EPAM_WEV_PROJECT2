package com.epam.examples.logic.impl;

import com.epam.examples.bean.Person;
import com.epam.examples.logic.PersonAction;

public class PersonActionImpl implements PersonAction, Runnable {

    private Person person;
    private double buyCoefficientForEuro;
    private double buyCoefficientForDollar;
    private double sellCoefficientForEuro;
    private double sellCoefficientForDollar;

    public PersonActionImpl(
            Person person,
            double buyCoefficientForEuro,
            double buyCoefficientForDollar,
            double sellCoefficientForEuro,
            double sellCoefficientForDollar
    ) {

        this.person = person;
        this.buyCoefficientForEuro = buyCoefficientForEuro;
        this.buyCoefficientForDollar = buyCoefficientForDollar;
        this.sellCoefficientForEuro = sellCoefficientForEuro;
        this.sellCoefficientForDollar = sellCoefficientForDollar;
    }

    @Override
    public void run() {



//                Thread thread1 = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("до покупки buyDollars(10)\t" +person);
//                        sellDollars(10);
//                        System.out.println("после покупки buyDollars(10)\t" +person);
//                    }
//                });
//                Thread thread2 = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("до покупки buyEuro(10)\t" +person);
//                        sellEuro(10);
//                        System.out.println("после покупки buyEuro(10)\t" +person);
//                    }
//                });
//                thread1.start();
//                Thread.sleep(1000);
//                thread2.start();
            //System.out.println("до покупки buyDollars(10)\t" + person);

            sellDollars(10);
           // System.out.println("после покупки buyDollars(10)\t" + person);




    }


    @Override
    public void sellDollars(double amount) {
        double belCash = person.getBelCash();
        double dollars = person.getDollars();
        person.setDollars(dollars - amount);
        person.setBelCash(belCash + amount * sellCoefficientForDollar);
    }

    @Override
    public void sellEuro(double amount) {
        double belCash = person.getBelCash();
        double euro = person.getEuro();
        person.setEuro(euro - amount);
        person.setBelCash(belCash + amount * sellCoefficientForEuro);
    }

    @Override
    public void buyDollars(double amount) {
        double belCash = person.getBelCash();
        double dollars = person.getDollars();
        person.setBelCash(belCash - amount * buyCoefficientForDollar);
        person.setDollars(dollars + amount);
    }

    @Override
    public void buyEuro(double amount) {
        double belCash = person.getBelCash();
        double euro = person.getEuro();
        person.setBelCash(belCash - amount * buyCoefficientForEuro);
        person.setEuro(euro + amount);
    }
}
