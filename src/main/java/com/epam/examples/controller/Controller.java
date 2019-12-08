package com.epam.examples.controller;

import com.epam.examples.bean.Person;

public class Controller implements Runnable {
    private final CommandProvider commandProvider = new CommandProvider();
    private String request;
    private Person person;
    private double amount;
    private double coefficient;

    public Controller(String request, Person person, double amount, double coefficient) {
        this.request = request;
        this.person = person;
        this.amount = amount;
        this.coefficient = coefficient;
    }

    @Override
    public void run() {
        try {
            Command command = commandProvider.getCommand(request);
            command.execute(person, amount, coefficient);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
