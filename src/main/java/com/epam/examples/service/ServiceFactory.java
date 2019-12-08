package com.epam.examples.service;

import com.epam.examples.service.impl.ActionServiceImpl;

public class ServiceFactory {
    private static final ActionService actionService = new ActionServiceImpl();
    private ServiceFactory(){}

    public static ActionService getActionService() {
        return actionService;
    }
}
