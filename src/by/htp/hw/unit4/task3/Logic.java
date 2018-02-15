package by.htp.hw.unit4.task3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Logic {

    private static NoteBook noteBook = NoteBook.getNoteBook();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void addNote() throws IOException {
        System.out.println("Please, enter the information about a new note\n " +
                "Name Country Telephone");

        String[] data = reader.readLine().split(" ");
        noteBook.getNotes().add(new Note(data[0], data[1], data[2]));
    }


    //TODO пока не работает
    public static void deleteNote() throws IOException {
        System.out.println("Please, enter the information about a removable record\n " +
                "Name Country Telephone");

        String[] data = reader.readLine().split(" ");
        noteBook.getNotes().remove(new Note(data[0], data[1], data[2]));
    }


    public static void findTheNote() throws IOException {
        System.out.println("Please, enter what are you looking for (one of this)\n" +
                "name/country/telephone");

        String line = reader.readLine().toLowerCase().trim();

        int count = 0;
        for (Note n : noteBook.getNotes()) {
            if (n.findNote(line) != null) {
                System.out.println(n.toString());
                count++;
            }
        }

        if (count == 0)
            System.out.println("No matches");
    }


    public static void printAllNotes() {
        for (Note n : noteBook.getNotes()) {
            System.out.println(n.toString());
        }
    }


    public static void main(String[] args) throws IOException {
        try {
            while (true) {
                System.out.println("Enter a desired value\n" +
                        "\"c\" - create a note\n" +
                        "\"r\" - read information about some note\n" +
                        "\"d\" - delete a note\n" +
                        "\"p\" - print all notes\n");

                //reader.mark(0);
                String command = reader.readLine().toLowerCase().trim();
                //reader.read(new char[' ']);
                switch (command) {
                    case "c":
                        addNote();
                        break;
                    case "r":
                        findTheNote();
                        break;
                    case "d":
                        deleteNote();
                        break;
                    case "p":
                        printAllNotes();
                }

                System.out.println("\nDo you want something else? Y/N");

                String command2 = reader.readLine().toLowerCase();

                if (command2.equals("n")) {
                    break;
                } else if (!command2.equals("y"))
                    System.out.println("Wrong data");
            }
        } catch (IOException e) {
            System.out.println("Wrong data");
        }
    }
}