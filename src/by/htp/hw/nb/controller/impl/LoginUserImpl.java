package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.UserService;
import by.htp.hw.nb.service.exception.ServiceException;

public class LoginUserImpl implements Command {

    @Override
    public String execute(String[] params) {

        String login = "";
        String password = "";

        String[] elements;
        for (int i = 1; i < params.length; i++) {
            elements = params[i].split("=");
            elements[1] = elements[1].trim();

            switch (elements[0].trim()) {
                case "login":
                    login = elements[1];
                    break;
                case "password":
                    password = elements[1];
            }
        }

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        String responce;

        try {
            userService.logination(new User());
            responce = "0 OK";
        } catch (ServiceException e) {
            // log
            e.printStackTrace();
            responce = "1 Error";
        }

        return responce;
    }
}
