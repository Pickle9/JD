package by.htp.hw.nb.service.impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import by.htp.hw.nb.dao.DAOFactory;
import by.htp.hw.nb.dao.NoteDAO;
import by.htp.hw.nb.entity.Note;
import by.htp.hw.nb.service.NoteService;

public class NoteServiceImpl implements NoteService {

    // TODO ПРОВЕРИТЬ ВЫЗОВЫ ОТСЮДА

    @Override
    public void create(Note note) throws IOException {
        // data validation

        DAOFactory daoFactory = DAOFactory.getInstance();
        NoteDAO noteDAO = daoFactory.getNoteDAO();
        noteDAO.create(note);
    }

    @Override
    public List<Note> find(Calendar date) throws IOException {

        DAOFactory daoFactory = DAOFactory.getInstance();
        NoteDAO noteDAO = daoFactory.getNoteDAO();

        return noteDAO.find(date);
    }

    @Override
    public void remove(int id) throws IOException {
        DAOFactory.getInstance().getNoteDAO().remove(id);
    }

    @Override
    public void edit(int id, String newText, int newYear) throws IOException {
        DAOFactory.getInstance().getNoteDAO().edit(id, newText, newYear);
    }
}
