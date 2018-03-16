package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.entity.Note;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;

public class CreateNoteImpl implements Command {

    /**
     * @param params [CREATE_NOTE], [idUser=..], [text=..]
     */
    @SuppressWarnings("all")
    @Override
    public String execute(String[] params) {

        String text = null;
        int id = -1;

        String[] elements;
        for (String s : params) {
            elements = s.split("=");

            switch (elements[0]) {
                case "idUser":
                    id = Integer.parseInt(elements[1]);
                    break;
                case "text":
                    text = elements[1];
            }
        }

        if (text == null || id == -1)
            return "1 ERROR";

        String response;
        try {
            ServiceFactory.getInstance().getNoteService().add(new Note(id, text));
            response = "0 OK";
        } catch (ServiceException e) {
            e.printStackTrace();
            response = "1 ERROR";
        }

        return response;
    }
}