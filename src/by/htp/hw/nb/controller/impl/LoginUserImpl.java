package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.controller.Responses;
import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.service.ServiceFactory;

public class LoginUserImpl implements Command {

    @Override
    public Responses execute(String[] params) {

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

        if (login.equals("") || password.equals("")) {
            return Responses.NOT_VALID_LOGIN_OR_PASSWORD;
        }

        ServiceFactory factory = ServiceFactory.getInstance();
        factory.getUserService().signIn(new User(login, password));

        return Responses.OK;
    }
}
