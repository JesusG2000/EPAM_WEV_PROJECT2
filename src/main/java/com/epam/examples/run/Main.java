package com.epam.examples.run;


import com.epam.examples.bean.Person;
import com.epam.examples.bean.TradeExchange;
import com.epam.examples.util.parser.DataParser;
import com.epam.examples.util.parser.ParserException;
import com.epam.examples.util.parser.impl.FileDataParser;
import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.ProviderException;
import com.epam.examples.util.provider.impl.FileDataProvider;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ProviderException, ParserException, InterruptedException {
        DataProvider<List<String>> dataProvider =new FileDataProvider("data\\information");
        DataParser parser =new FileDataParser(dataProvider);
        List<Person> persons = parser.getPersons();

        TradeExchange tradeExchange =parser.getTradeExchange();
        tradeExchange.setPersons(persons);

        TradeHelper helper =new TradeHelper(tradeExchange);
        helper.startTrading();
       // System.out.println(tradeExchange.getPersons());
      //  Thread thread =new Thread(new TradeExchangeActionImpl(tradeExchange));
        //thread.start();



//        TradeExchange tradeExchange =new TradeExchange(3,5,1,1);
//        List<Person> list =new LinkedList<>();
//        list.add(new Person("Ivan",30,30,50));
//        list.add(new Person("Igor",360,70,90));
//        tradeExchange.setPersons(list);
//
//        Thread thread =new Thread(new TradeExchangeActionImpl(tradeExchange));
//        Thread thread1 =new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                    System.out.println(tradeExchange.getPersons().get(0));
//                    System.out.println(tradeExchange.getPersons().get(1));
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        thread.start();
//        Thread.sleep(10);
//        thread1.start();
       // thread.join();
       // thread1.join();
    }
}
