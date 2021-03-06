package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;

public class EditNoteImpl implements Command {

    /**
     * @param params [EDIT_NOTE], [idUser=..], [idNote=..], [newText=..]
     */
    @Override
    public String execute(String[] params) {

        String newText = null;
        int idNote = -1;
        int idUser = -1;

        String[] elements;
        for (String s : params) {
            elements = s.split("=");

            switch (elements[0]) {
                case "idNote":
                    idNote = Integer.parseInt(elements[1]);
                    break;
                case "idUser":
                    idUser = Integer.parseInt(elements[1]);
                    break;
                case "newText": {
                    newText = elements[1];
                }
            }
        }

        if (idNote == -1 || idUser == -1 || newText == null)
            return "1 ERROR";

        String response;
        try {
            ServiceFactory.getInstance().getNoteService().edit(idNote, idUser, newText);
            response = "0 OK";
        } catch (ServiceException e) {
            e.printStackTrace();
            response = "1 ERROR";
        }

        return response;
    }

}