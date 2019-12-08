package com.epam.examples.trade_operation;

import com.epam.examples.bean.Person;
import com.epam.examples.controller.Command;

public class WrongRequest implements Command {
    @Override
    public void execute(Person person, double amount, double coefficient) {
        System.out.println("wrong request");
    }
}
