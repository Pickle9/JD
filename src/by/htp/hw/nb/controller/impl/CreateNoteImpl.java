package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.controller.Responses;
import by.htp.hw.nb.entity.Note;
import by.htp.hw.nb.service.NoteService;
import by.htp.hw.nb.service.ServiceFactory;

import java.io.IOException;
import java.util.GregorianCalendar;

public class CreateNoteImpl implements Command {

    @Override
    public Responses execute(String[] params) throws IOException {
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

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(year, month, day);

        noteService.create(new Note(calendar, newContent));

        return Responses.OK;
    }
}
