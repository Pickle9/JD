package by.htp.hw.unit4.task3;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {

    //singleton
    private static NoteBook noteBook;

    static {
        noteBook = new NoteBook();
    }

    private NoteBook() {
    }

    public static NoteBook getNoteBook() {
        return noteBook;
    }


    //Notes
    private List<Note> notes = new ArrayList<>();

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
