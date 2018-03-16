package by.htp.hw.nb.service.impl;

import java.util.List;

import by.htp.hw.nb.dao.DAOFactory;
import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.Note;
import by.htp.hw.nb.service.NoteService;
import by.htp.hw.nb.service.exception.ServiceException;

public class NoteServiceImpl implements NoteService {

    @Override
    public void add(Note note) throws ServiceException {

        try {
            DAOFactory.getInstance().getNoteDAO().add(note);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Note> findWithContent(int id, String text) throws ServiceException {

        List<Note> noteList;
        try {
            noteList = DAOFactory.getInstance().getNoteDAO().findWithContent(id, text);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return noteList;
    }

    @Override
    public void remove(int idNote, int idUser) throws ServiceException {

        try {
            DAOFactory.getInstance().getNoteDAO().remove(idNote, idUser);
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void edit(int idNote, int idUser, String text) throws ServiceException {

        try {
            DAOFactory.getInstance().getNoteDAO().edit(idNote, idUser, text);
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<String> getAllNotes(int idUser) throws ServiceException {

        try {
            return DAOFactory.getInstance().getNoteDAO().getAllNotes(idUser);
        }
        catch (DAOException e) {
            throw new ServiceException();
        }
    }
}