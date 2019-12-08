package com.epam.examples.controller;

import com.epam.examples.trade_operation.*;

import java.util.HashMap;
import java.util.Map;
//package-private
final class CommandProvider {
    private final Map<CommandName, Command> exchangeOperation = new HashMap<>();

    CommandProvider() {
        exchangeOperation.put(CommandName.BUY_DOLLARS, new BuyDollars());
        exchangeOperation.put(CommandName.BUY_EURO, new ByeEuro());
        exchangeOperation.put(CommandName.SELL_DOLLARS, new SellDollars());
        exchangeOperation.put(CommandName.SELL_EURO, new SellEuro());
        exchangeOperation.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String request) {
        CommandName commandName = CommandName.valueOf(request.toUpperCase());
        return exchangeOperation.get(commandName);

    }
}
