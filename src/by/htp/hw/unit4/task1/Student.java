package unit4.task1;

import java.util.ArrayList;

public class Student {

    private String name;
    private ArrayList<Integer> assessments = new ArrayList<>();

    public Student(String name, int... assessments) {
        this.name = name;

        for (int i : assessments) {
            this.assessments.add(i) ;
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getAssessments() {
        return assessments;
    }

    public int getAverageRating() {
        int sum = 0;

        for (int i : assessments) {
            sum += i;
        }

        return sum / assessments.size();
    }

    public boolean isHighAchiever() {
        return getAverageRating() > 8;
    }

    public boolean isDowager() {
        return getAverageRating() <= 2;
    }


    public static void main(String[] args) {

        Group group1 = new Group(101);

        Student student1 = new Student("Petrov", 1, 2, 1);
        Student student2 = new Student("Ivamov", 4, 5, 6);
        Student student3 = new Student("Sidorov", 9, 10, 10);

        group1.addStudent(student1);
        group1.addStudent(student2);
        group1.addStudent(student3);

        //средний балл учебной группы
        System.out.println(String.format("Средний балл учебной группы %o: %o\n",group1.getGroupNumber(), group1.getGroupAverageRating()));

        //средний балл каждого студента
        for (Student s : group1.getStudentsList()) {
            System.out.println(s.name + " " + s.getAverageRating());
        }

        System.out.println();

        //число отличников
        System.out.println(group1.getHighAchievers());

        System.out.println();

        //число двоечников
        System.out.println(group1.getDowagers());
    }
}
