package by.htp.hw.nb.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import by.htp.hw.nb.entity.Note;

public interface NoteService {

    void create(Note note) throws IOException;

    void remove(int id) throws IOException;

    void edit(int id, String newText, int newYear)throws IOException;

    List<Note> find(Calendar date) throws IOException;
}
