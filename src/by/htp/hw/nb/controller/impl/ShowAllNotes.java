package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;
import by.htp.hw.nb.view.ConsoleHelper;

public class ShowAllNotes implements Command {

    /**
     * @param params [SHOW_All_NOTES], [idUser=..]
     */
    @Override
    public String execute(String[] params) {

        int idUser = -1;

        for (String s : params) {
            String[] elements = s.split("=");

            if (elements[0].equals("idUser"))
                idUser = Integer.parseInt(elements[1]);
        }

        if (idUser == -1)
            return "1 ERROR";

        String response;
        try {
            new ConsoleHelper().printList(ServiceFactory.getInstance().getNoteService().getAllNotes(idUser));
            response = "0 OK";
        }
        catch (ServiceException e) {
            e.printStackTrace();
            response = "1 ERROR";
        }

        return response;
    }
}
