package com.epam.examples.util.parser;



import com.epam.examples.bean.Person;
import com.epam.examples.bean.TradeExchange;
import com.epam.examples.util.provider.ProviderException;

import java.util.List;

public interface DataParser {


    List<Person> getPersons() throws ParserException, ProviderException;

    TradeExchange getTradeExchange() throws ParserException, ProviderException;


}
