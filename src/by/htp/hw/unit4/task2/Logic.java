package by.htp.hw.unit4.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Logic {

    private static University university;

    public static void initUniversity() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Let's create a university!\n" +
                "Enter a name and count of places.\n" +
                "\"name\" \"count of places\"\n");

        String[] line = reader.readLine().split(" ");
        university = new University(line[0], Integer.parseInt(line[1]));
    }

    public static void initAbiturients() {

        int countOfAbiturients = (int) (Math.random() * 100);

        for (int i = 0; i < countOfAbiturients; i++) {
            university.getGroup().add(new Abiturient(("Student №" + i), (int) (Math.random() * 100)));
        }
    }

    public static void printEnrolledStudents() {

        int countOfPlaces = university.getCountOfPlaces();

        for (Abiturient abiturient : university.getGroup()) {
            System.out.println(abiturient.toString());

            countOfPlaces--;
            if (countOfPlaces < 0)
                break;
        }

        System.out.println("Count of places: " + university.getCountOfPlaces());
        System.out.println("Count of abiturients: " + university.getGroup().size());
    }


    public static void main(String[] args) {

        while (true) {
            try {

                initUniversity();
                initAbiturients();
                printEnrolledStudents();
                break;

            } catch (Exception e) {
                System.out.println("Wrong data, try again.\n");
            }
        }
    }
}
