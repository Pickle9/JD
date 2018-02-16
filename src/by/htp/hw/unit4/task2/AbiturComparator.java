package by.htp.hw.unit4.task2;

import java.util.Comparator;

public class AbiturComparator implements Comparator<Abiturient>{

    @Override
    public int compare(Abiturient o1, Abiturient o2) {
        return -Integer.compare(o1.getAssessment(), o2.getAssessment());
    }
}
