package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;

public class DeleteUserImpl implements Command {

    /**
     * @param params [DELETE_USER], [idUser=..], [login=..], [password=..]
     */
    @Override
    public String execute(String[] params) {

        int id = -1;
        String login = null;
        String password = null;

        String[] elements;
        for (String s : params) {
            elements = s.split("=");

            switch (elements[0]) {
                case "idUser":
                    id = Integer.parseInt(elements[1]);
                    break;
                case "login":
                    login = elements[1];
                    break;
                case "password":
                    password = elements[1];
            }
        }

        if (id == -1 || login == null || password == null)
            return "1 ERROR";

        User user = new User(id, login, password);

        String response;
        try {
            ServiceFactory.getInstance().getUserService().deleteUser(user);
            response = "0 OK";
        } catch (ServiceException e) {
            e.printStackTrace();
            response = "1 ERROR";
        }

        return response;
    }
}
