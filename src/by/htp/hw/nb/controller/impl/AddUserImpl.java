package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.entity.UserInfo;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;

public class AddUserImpl implements Command {

    /**
     * @param params [ADD_USER], [idUser=..], [login=..], [password=..], [name=..], [surname=..]
     */
    @Override
    public String execute(String[] params) {

        String id = null;
        String login = null;
        String password = null;
        String name = null;
        String surname = null;

        String[] elements;
        for (String s : params) {
            elements = s.split("=");

            switch (elements[0]) {
                case "idUser":
                    id = elements[1];
                    break;
                case "login":
                    login = elements[1];
                    break;
                case "password":
                    password = elements[1];
                    break;
                case "name":
                    name = elements[1];
                    break;
                case "surname":
                    surname = elements[1];
            }
        }

        if (id == null || login == null ||
                password == null || name == null ||
                surname == null)
            return "1 ERROR";

        UserInfo user = new UserInfo(Integer.parseInt(id), login, password, name, surname);

        String response;
        try {
            ServiceFactory.getInstance().getUserService().addUser(user);
            response = "0 OK";
        } catch (ServiceException e) {
            e.printStackTrace();
            response = "1 ERROR";
        }

        return response;
    }
}
