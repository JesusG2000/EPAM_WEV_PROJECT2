package com.epam.examples.logic.impl;

import com.epam.examples.bean.Person;
import com.epam.examples.bean.TradeExchange;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TradeExchangeActionImpl implements Runnable {
    private TradeExchange tradeExchange;

    public TradeExchangeActionImpl(TradeExchange tradeExchange) {
        this.tradeExchange = tradeExchange;
    }

    @Override
    public void run() {
        ExecutorService executorService= Executors.newFixedThreadPool(tradeExchange.getPersons().size());
        for (Person p : tradeExchange.getPersons()) {
            executorService.submit(new PersonActionImpl(p,
                    tradeExchange.getBuyCoefficientForEuro(),
                    tradeExchange.getBuyCoefficientForDollar(),
                    tradeExchange.getSellCoefficientForEuro(),
                    tradeExchange.getSellCoefficientForDollar()));

        }
        executorService.shutdown();
    }
}
