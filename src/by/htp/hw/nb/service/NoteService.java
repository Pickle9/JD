package by.htp.hw.nb.service;

import java.util.Calendar;
import java.util.List;

import by.htp.hw.nb.entity.Note;
import by.htp.hw.nb.service.exception.ServiceException;

public interface NoteService {

    void create(Note note) throws ServiceException;
    List<Note> find(int id, String text) throws ServiceException;
    void edit(int id, String text, Calendar date) throws ServiceException;
}
