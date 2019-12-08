package com.epam.examples.logic;

import com.epam.examples.bean.Person;
import com.epam.examples.bean.TradeExchange;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TradeExchangeAction implements Runnable {
    private TradeExchange tradeExchange;

    public TradeExchangeAction(TradeExchange tradeExchange) {
        this.tradeExchange = tradeExchange;
    }

    @Override
    public void run() {
        ExecutorService executorService= Executors.newFixedThreadPool(tradeExchange.getPersons().size());
        for (Person p : tradeExchange.getPersons()) {
            executorService.submit(new PersonAction(p,
                    tradeExchange.getBuyCoefficientForEuro(),
                    tradeExchange.getBuyCoefficientForDollar(),
                    tradeExchange.getSellCoefficientForEuro(),
                    tradeExchange.getSellCoefficientForDollar()));

        }
        executorService.shutdown();
    }
}
