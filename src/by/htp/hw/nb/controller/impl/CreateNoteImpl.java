package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.entity.Note;
import by.htp.hw.nb.service.NoteService;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;

public class CreateNoteImpl implements Command {

    @Override
    public String execute(String[] params) {
        String newContent = "";
        int year = 0;
        int month = 0;
        int day = 0;

        String[] elements;
        for (int i = 1; i < params.length; i++) {
            elements = params[i].split("=");
            elements[1] = elements[1].trim();

            switch (elements[0].trim()) {
                case "newContent":
                    newContent = elements[1];
                    break;
                case "year":
                    year = Integer.parseInt(elements[1]);
                    break;
                case "month":
                    month = Integer.parseInt(elements[1]);
                    break;
                case "day":
                    day = Integer.parseInt(elements[1]);
            }
        }

        ServiceFactory factory = ServiceFactory.getInstance();
        NoteService noteService = factory.getNoteService();

        Note newNote = new Note();
        String response;
        try {
            noteService.create(newNote);
            response = "0 OK";
        } catch (ServiceException e) {
            // log
            e.printStackTrace();
            response = "1 Error";
        }

        return response;
    }
}