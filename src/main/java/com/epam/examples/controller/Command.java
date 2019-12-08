package com.epam.examples.controller;

import com.epam.examples.bean.Person;
import com.epam.examples.service.ServiceException;

public interface Command {
    void execute(Person person,double amount, double coefficient) throws InterruptedException;
}
