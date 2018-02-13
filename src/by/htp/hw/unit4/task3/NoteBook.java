package unit4.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NoteBook {

    private static NoteBook noteBook;

    static {
        noteBook = new NoteBook();
    }

    private NoteBook() {
    }

    public static NoteBook getNoteBook() {
        return noteBook;
    }


    private ArrayList<Note> notes = new ArrayList<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void addNote() {
        System.out.println("Please, enter the information about a new note\n " +
                "Name Country Telephone");

        String[] data;

        try {
            data = reader.readLine().split(" ");
            notes.add(new Note(data[0], data[1], data[2]));
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Wrong data");
        }
    }

    //пока не работает
    public void deleteNote() {
        System.out.println("Please, enter the information about a removable record\n " +
                "Name Country Telephone");

        String[] data;

        try {
            data = reader.readLine().split(" ");
            notes.remove(new Note(data[0], data[1], data[2]));
        } catch (Exception e) {
            System.out.println("Wrong data");
        }
    }

    public void findTheNote() {
        System.out.println("Please, enter what are you looking for (one of this)\n" +
                "name/country/telephone");

        String line = "";
        try {
            line = reader.readLine().toLowerCase().trim();
        } catch (IOException e) {
            System.out.println("Wrong data");
        }

        int count = 0;
        for (Note n : notes) {
            if (n.findNote(line) != null) {
                System.out.println(n.toString());
                count++;
            }
        }

        if (count == 0)
            System.out.println("No matches");
    }

    public void printAllNotes() {
        for (Note n : notes) {
            System.out.println(n.toString());
        }
    }


    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Enter a desired value\n" +
                    "\"c\" - create a note\n" +
                    "\"r\" - read information about some note\n" +
                    "\"d\" - delete a note\n" +
                    "\"p\" - print all notes\n");

            reader.mark(0);
            String command = reader.readLine().toLowerCase().trim();
            reader.read(new char[' ']); // сюда не смотри!!!
            switch (command) {
                case "c": getNoteBook().addNote();
                    break;
                case "r": getNoteBook().findTheNote();
                    break;
                case "d": getNoteBook().deleteNote();
                    break;
                case "p": getNoteBook().printAllNotes();
            }

            System.out.println("\nDo you want something else? Y/N");

            String command2 = reader.readLine().toLowerCase();

            if (command2.equals("y")) {
                continue;
            } else if (command2.equals("n")) {
                break;
            } else System.out.println("Wrong data");

        }
    }
}
