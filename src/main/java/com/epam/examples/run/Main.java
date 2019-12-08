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

    }
}
