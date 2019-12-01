package com.epam.examples.logic.impl;

import com.epam.examples.bean.Person;

import java.util.List;


public class PersonStatistic implements Runnable {
    private List<Person> list;

    public PersonStatistic(List<Person> list) {
        this.list = list;
    }

    @Override
    public void run() {


            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Person p : list) {
                System.out.println(p);
            }


    }
}

