package com.epam.examples.trade_operation;

import com.epam.examples.bean.Person;
import com.epam.examples.controller.Command;
import com.epam.examples.service.ActionService;
import com.epam.examples.service.ServiceException;
import com.epam.examples.service.ServiceFactory;

public class BuyDollars implements Command {


    @Override
    public void execute(Person person,double amount, double coefficient) throws InterruptedException {
        try {
        ActionService service = ServiceFactory.getActionService();
            service.buyDollars(person,amount,coefficient);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }
}
