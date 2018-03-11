package by.htp.hw.nb.entity;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Note {

    private int idUser;
    private String date;
    private String text;

    public Note() {
        super();
    }

    public Note(int idUser, String text) {
        super();
        this.idUser = idUser;
        this.text = text;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.date = dateFormat.format(new GregorianCalendar().getTime());
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (idUser != note.idUser) return false;
        if (date != null ? !date.equals(note.date) : note.date != null) return false;
        return text != null ? text.equals(note.text) : note.text == null;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%o %s %s", idUser, date, text);
    }

    public String toStringWithoutIdUser() {
        return String.format("%s %s", date, text);
    }
}
