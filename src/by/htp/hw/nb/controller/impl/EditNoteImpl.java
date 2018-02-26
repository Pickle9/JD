package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.controller.Responses;
import by.htp.hw.nb.service.NoteService;
import by.htp.hw.nb.service.ServiceFactory;

import java.io.IOException;

public class EditNoteImpl implements Command {

    @Override
    public Responses execute(String[] params) throws IOException {

        String newText = "";
        int id = -1;
        int newYear = 0;

        String[] elements;
        for (int i = 1; i < params.length; i++) {
            elements = params[i].split("=");
            elements[1] = elements[1].trim();

            switch (elements[0].trim()) {
                case "id":
                    id = Integer.parseInt(elements[1]);
                    break;
                case "text":
                    newText = elements[1];
                    break;
                case "year":
                    newYear = Integer.parseInt(elements[1]);
            }
        }

        ServiceFactory factory = ServiceFactory.getInstance();
        NoteService noteService = factory.getNoteService();

        if (id == -1)
            return Responses.NOT_VALID_ID;

        noteService.edit(id, newText, newYear);

        return Responses.OK;
    }

}
