package com.epam.examples.service;

import com.epam.examples.bean.Person;

public interface ActionService {

    void buyDollars(Person person, double amount, double coefficient) throws InterruptedException, ServiceException;

    void buyEuro(Person person, double amount, double coefficient) throws InterruptedException, ServiceException;

    void sellDollars(Person person, double amount, double coefficient) throws InterruptedException, ServiceException;

    void sellEuro(Person person, double amount, double coefficient) throws InterruptedException, ServiceException;

}
