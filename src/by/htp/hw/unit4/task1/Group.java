package unit4.task1;

import java.util.ArrayList;

public class Group {

    private int groupNumber;
    private ArrayList<Student> studentsList = new ArrayList<>();

    public Group(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public void deleteStudent(Student student) {
        studentsList.remove(student);
    }
    
    public int getGroupAverageRating() {
        int sum = 0;

        for (Student s : studentsList) {
            sum += s.getAverageRating();
        }

        return sum / studentsList.size();
    }

    public ArrayList<Student> getHighAchievers() {
        ArrayList<Student> highAchievers = new ArrayList<>();

        for (Student s : studentsList) {
            if (s.isHighAchiever()) {
                highAchievers.add(s);
            }
        }

        return highAchievers;
    }

    public ArrayList<Student> getDowagers() {
        ArrayList<Student> dowagers = new ArrayList<>();

        for (Student s : studentsList) {
            if (s.isDowager()) {
                dowagers.add(s);
            }
        }

        return dowagers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (groupNumber != group.groupNumber) return false;
        return studentsList != null ? studentsList.equals(group.studentsList) : group.studentsList == null;

    }

    @Override
    public int hashCode() {
        int result = groupNumber;
        result = 31 * result + (studentsList != null ? studentsList.hashCode() : 0);
        return result;
    }
}
