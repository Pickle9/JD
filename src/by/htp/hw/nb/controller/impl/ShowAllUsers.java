package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;
import by.htp.hw.nb.view.ConsoleHelper;

public class ShowAllUsers implements Command {

    /**
     * @param params [SHOW_All_USERS]
     */
    @Override
    public String execute(String[] params) {

        String response;
        try {
            new ConsoleHelper().printList(ServiceFactory.getInstance().getUserService().getAllUsers());
            response = "0 OK";
        }
        catch (ServiceException e) {
            e.printStackTrace();
            response = "1 ERROR";
        }

        return response;
    }
}
