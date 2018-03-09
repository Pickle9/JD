package by.htp.hw.nb.entity;

import java.util.Calendar;

public class Note {

    private int idUser;
    private Calendar date;// GregorianCalendar
    private String text;

    public Note() {
        super();
    }

    public Note(int idUser, String text, Calendar date) {
        super();
        this.idUser = idUser;
        this.date = date;
        this.text = text;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // equals, hashCode

    // toString
}
