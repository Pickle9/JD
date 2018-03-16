package by.htp.hw.nb.service;

import java.util.List;

import by.htp.hw.nb.entity.Note;
import by.htp.hw.nb.service.exception.ServiceException;

public interface NoteService {

    void add(Note note) throws ServiceException;

    List<Note> findWithContent(int id, String text) throws ServiceException;

    void edit(int idNote, int idUser, String text) throws ServiceException;

    void remove(int idNote, int idUser) throws ServiceException;

    List<String> getAllNotes(int idUser) throws ServiceException;
}