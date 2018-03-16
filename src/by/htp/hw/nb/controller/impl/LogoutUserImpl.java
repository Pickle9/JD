package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;

public class LogoutUserImpl implements Command {

    /**
     * @param params [LOGOUT_USER], [idUser=..], [login=..], [password=..]
     */
    @SuppressWarnings("all")
    @Override
    public String execute(String[] params) {

        int idUser = -1;
        String login = null;
        String password = null;

        String[] elements;
        for (String s : params) {
            elements = s.split("=");

            switch (elements[0]) {
                case "idUser":
                    idUser = Integer.parseInt(elements[1]);
                case "login":
                    login = elements[1];
                    break;
                case "password":
                    password = elements[1];
            }
        }

        if (idUser == -1 || login == null || password == null)
            return "1 ERROR";

        String responce;

        try {
            ServiceFactory.getInstance().getUserService().logOut(new User(idUser, login, password));
            responce = "0 OK";
        } catch (ServiceException e) {
            // log
            e.printStackTrace();
            responce = "1 Error";
        }

        return responce;
    }
}
