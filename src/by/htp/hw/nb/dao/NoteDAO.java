package by.htp.hw.nb.dao;

import by.htp.hw.nb.entity.Note;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public interface NoteDAO {

    void create(Note note) throws IOException;

    void remove(int id) throws IOException;

    void edit(int id, String newText, int newYear)throws IOException;

    List<Note> find(Calendar date) throws IOException;
}