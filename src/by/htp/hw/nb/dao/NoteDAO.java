package by.htp.hw.nb.dao;

import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.Note;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public interface NoteDAO {

    void add(Note note) throws DAOException;
    List<Note> findWithContent(int id, String text) throws DAOException;
    //void remove(int id) throws DAOException;

}