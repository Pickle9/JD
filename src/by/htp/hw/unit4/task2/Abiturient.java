package by.htp.hw.unit4.task2;

public class Abiturient {

    private String fullName;
    private int assessment;

    public Abiturient(String fullName, int assessment) {
        this.fullName = fullName;
        this.assessment = assessment;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    @Override
    public String toString() {
        return  String.format("fullName= %-11s, assessment= %o", fullName, assessment);
    }
}
