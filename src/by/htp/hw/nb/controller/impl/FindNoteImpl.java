package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.service.NoteService;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;

public class FindNoteImpl implements Command {
    @Override
    public String execute(String[] params) {
        String text = "";
        int id = -1;

        String[] elements;
        for (int i = 1; i < params.length; i++) {
            elements = params[i].split("=");
            elements[1] = elements[1].trim();

            switch (elements[0].trim()) {
                case "id":
                    id = Integer.parseInt(elements[1]);
                    break;
                case "text":
                    text = elements[1];
            }
        }

        ServiceFactory factory = ServiceFactory.getInstance();
        NoteService noteService = factory.getNoteService();

        String responce;

        try {
            noteService.find(id, text);
            responce = "0 OK";
        } catch (ServiceException e) {
            // log
            e.printStackTrace();
            responce = "1 Error";
        }

        return responce;
    }
}
