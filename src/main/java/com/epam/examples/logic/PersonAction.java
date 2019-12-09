package com.epam.examples.logic;

import com.epam.examples.bean.Person;
import com.epam.examples.controller.Controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PersonAction implements Runnable {

    private Person person;
    private double buyCoefficientForEuro;
    private double buyCoefficientForDollar;
    private double sellCoefficientForEuro;
    private double sellCoefficientForDollar;

    public PersonAction(
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
    public  void run() {
        int countOfPersonOperation = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(countOfPersonOperation);
        for (int i = 0; i < countOfPersonOperation; i++) {
//            executorService.submit(new Controller("BUY_DOLLARS",person,10,buyCoefficientForDollar));
//            executorService.submit(new Controller("BUY_DOLLARS",person,10,buyCoefficientForDollar));
//            executorService.submit(new Controller("SELL_DOLLARS",person,10,buyCoefficientForDollar));
//        }
            int executingCommand = (int) (Math.random() * 4);
            switch (executingCommand) {
                case 0: {
                   executorService.submit(new Controller("BUY_DOLLARS",person,10,buyCoefficientForDollar));
                    break;
                }
                case 1: {
                    executorService.submit(new Controller("BUY_EURO",person,10,buyCoefficientForEuro));
                    break;
                }
                case 2: {
                    executorService.submit(new Controller("SELL_DOLLARS",person,10,sellCoefficientForDollar));
                    break;
                }
                case 3: {
                    executorService.submit(new Controller("SELL_EURO",person,10,sellCoefficientForEuro));
                    break;
                }

            }
        }
        executorService.shutdown();

    }



}
