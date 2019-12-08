package com.epam.examples.run;

import com.epam.examples.bean.TradeExchange;
import com.epam.examples.logic.PersonStatistic;
import com.epam.examples.logic.TradeExchangeAction;

public class TradeHelper {
    private TradeExchange tradeExchange;

    public TradeHelper(TradeExchange tradeExchange) {
        this.tradeExchange = tradeExchange;
    }

    public void startTrading() throws InterruptedException {
       // while (true) {

            Thread thread = new Thread(new TradeExchangeAction(tradeExchange));
            Thread thread1 = new Thread(new PersonStatistic(tradeExchange.getPersons()));


            thread.start();
            thread1.start();

            thread.join();
            thread1.join();
      //  }
    }
}
