package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;

public class RemoveNoteImpl implements Command {

    /**
     * @param params [REMOVE_NOTE], [idUser=..], [idNote=..]
     */
    @Override
    public String execute(String[] params) {

        int idUser = -1;
        int idNote = -1;

        String[] elements;
        for (String s : params) {
            elements = s.split("=");

            switch (elements[0]) {
                case "idUser":
                    idUser = Integer.parseInt(elements[1]);
                    break;
                case "idNote":
                    idNote = Integer.parseInt(elements[1]);
            }
        }

        if (idNote == -1 || idUser == -1)
            return "1 ERROR";

        String response;
        try {
            ServiceFactory.getInstance().getNoteService().remove(idNote, idUser);
            response = "0 OK";
        } catch (ServiceException e) {
            e.printStackTrace();
            response = "1 ERROR";
        }

        return response;
    }
}
