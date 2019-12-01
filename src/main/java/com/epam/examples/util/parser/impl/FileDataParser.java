package com.epam.examples.util.parser.impl;


import com.epam.examples.bean.Person;
import com.epam.examples.bean.TradeExchange;
import com.epam.examples.util.parser.DataParser;
import com.epam.examples.util.parser.ParserException;
import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.ProviderException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDataParser implements DataParser {
    private static final Pattern PERSON_PARAMS = Pattern.compile("[a-zA-Z]+\\s([0-9]+\\.[0-9]+\\s){2}[0-9]+\\.[0-9]+$");
    private static final Pattern TRADE_EXCHANGE_PARAMS = Pattern.compile("([0-9]+\\.[0-9]+\\s){3}[0-9]+\\.[0-9]+$");
    private DataProvider<List<String>> provider;

    public FileDataParser(DataProvider<List<String>> provider) {
        this.provider = provider;
    }

    @Override
    public TradeExchange getTradeExchange() throws ParserException, ProviderException {
        List<String> lines = getLines(provider.getData(), TRADE_EXCHANGE_PARAMS);

        try {

            String[] divider = lines.get(0).split(" ");

            double buyCoefficientForEuro = Double.parseDouble(divider[0]);
            double buyCoefficientForDollar = Double.parseDouble(divider[1]);
            double sellCoefficientForEuro = Double.parseDouble(divider[2]);
            double sellCoefficientForDollar = Double.parseDouble(divider[3]);

            return new TradeExchange(buyCoefficientForEuro, buyCoefficientForDollar, sellCoefficientForEuro, sellCoefficientForDollar);


        } catch (NumberFormatException e) {
            throw new ParserException(e);
        }
    }

    @Override
    public List<Person> getPersons() throws ParserException, ProviderException {
        List<String> lines = getLines(provider.getData(), PERSON_PARAMS);
        List<Person> persons = new ArrayList<>();
        try {
            for (String line : lines) {
                String[] divider = line.split(" ");
                String name = divider[0];
                double euro = Double.parseDouble(divider[1]);
                double dollars = Double.parseDouble(divider[2]);
                double belCash = Double.parseDouble(divider[3]);
                persons.add(new Person(name, euro, dollars, belCash));
            }
        } catch (NumberFormatException e) {
            throw new ParserException(e);
        }
        return persons;
    }

    private List<String> getLines(List<String> lines, Pattern pattern) {
        List<String> formatList = new ArrayList<>();
        for (String l : lines) {
            Matcher matcher = pattern.matcher(l);
            while (matcher.find()) {
                formatList.add(l);
            }
        }
        return formatList;
    }
}
