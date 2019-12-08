package com.epam.examples.service.impl;

import com.epam.examples.bean.Person;
import com.epam.examples.service.ActionService;
import com.epam.examples.service.ServiceException;

import java.util.concurrent.TimeUnit;

public class ActionServiceImpl implements ActionService {
    @Override
    public void buyDollars(Person person, double amount, double coefficient) throws InterruptedException, ServiceException {
        System.out.println(person + "\t WANT to buy DOLLARS");
        TimeUnit.SECONDS.sleep(1);
        double belCash = person.getBelCash();
        double dollars = person.getDollars();
        isEnough(person,belCash,- amount * coefficient);
        person.setBelCash(belCash - amount * coefficient);
        person.setDollars(dollars + amount);
        System.out.println(person + "\t STOP to buy DOLLARS");
    }

    @Override
    public void buyEuro(Person person, double amount, double coefficient) throws InterruptedException, ServiceException {
        System.out.println(person + "\t WANT to buy EURO");
        TimeUnit.SECONDS.sleep(1);
        double belCash = person.getBelCash();
        double euro = person.getEuro();
        isEnough(person,belCash,- amount * coefficient);
        person.setBelCash(belCash - amount * coefficient);
        person.setEuro(euro + amount);
        System.out.println(person + "\t STOP to buy EURO");
    }

    @Override
    public void sellDollars(Person person, double amount, double coefficient) throws InterruptedException, ServiceException {
        System.out.println(person + "\t WANT to sell DOLLARS");
        TimeUnit.SECONDS.sleep(1);
        double belCash = person.getBelCash();
        double dollars = person.getDollars();
        isEnough(person,dollars,- amount);
        person.setDollars(dollars - amount);
        person.setBelCash(belCash + amount * coefficient);
        System.out.println(person + "\t STOP to sell DOLLARS");
    }

    @Override
    public void sellEuro(Person person, double amount, double coefficient) throws InterruptedException, ServiceException {
        System.out.println(person + "\t WANT to sell EURO");
        TimeUnit.SECONDS.sleep(1);
        double belCash = person.getBelCash();
        double euro = person.getEuro();
        isEnough(person,euro,- amount);
        person.setEuro(euro - amount);
        person.setBelCash(belCash + amount * coefficient);
        System.out.println(person + "\t STOP to sell EURO");
    }

    private void isEnough(Person person, double currency, double value) throws ServiceException {
        if(currency+value<0){
            throw new ServiceException(person+"\tDEAL has been denied");
        }
    }
}
