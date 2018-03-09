package by.htp.hw.nb.controller.impl;

import by.htp.hw.nb.controller.Command;
import by.htp.hw.nb.service.NoteService;
import by.htp.hw.nb.service.ServiceFactory;
import by.htp.hw.nb.service.exception.ServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditNoteImpl implements Command {

    @Override
    public String execute(String[] params) {

        String newText = "";
        int id = -1;
        Calendar newDate = Calendar.getInstance();

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
                case "year": {
                    try {
                        newDate.setTime(new SimpleDateFormat("yyyy").parse(elements[1]));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        ServiceFactory factory = ServiceFactory.getInstance();
        NoteService noteService = factory.getNoteService();

        String responce;

        try {
            noteService.edit(id, newText, newDate);
            responce = "0 OK";
        } catch (ServiceException e) {
            // log
            e.printStackTrace();
            responce = "1 Error";
        }

        return responce;
    }

}
