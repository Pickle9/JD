package by.htp.hw.nb.service.impl;

import java.util.Calendar;
import java.util.List;

import by.htp.hw.nb.dao.DAOFactory;
import by.htp.hw.nb.dao.NoteDAO;
import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.Note;
import by.htp.hw.nb.service.NoteService;
import by.htp.hw.nb.service.exception.ServiceException;

public class NoteServiceImpl implements NoteService {

    @Override
    public void create(Note note) throws ServiceException {
        // data validation

        DAOFactory daoFactory = DAOFactory.getInstance();
        NoteDAO noteDAO = daoFactory.getNoteDAO();

        try {
            noteDAO.add(note);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Note> find(int id, String text) throws ServiceException {

        DAOFactory daoFactory = DAOFactory.getInstance();
        NoteDAO noteDAO = daoFactory.getNoteDAO();

        List<Note> noteList;

        try {
            noteList = noteDAO.findWithContent(id, text);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return noteList;
    }

    @Override
    public void edit(int id, String text, Calendar date) throws ServiceException {
        //TODO
    }
}
