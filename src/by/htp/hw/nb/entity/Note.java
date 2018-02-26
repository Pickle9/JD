package by.htp.hw.nb.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Note {
	private static int id;
	private Calendar date;// GregorianCalendar
	private String text;

	public Note(Calendar date, String text) {
		id++;
		this.date = date;
		this.text = text;
	}

	public int getId() {
		return id;
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

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		return id + " " + dateFormat.format(date.getTime()) + " " + text;
	}
}
