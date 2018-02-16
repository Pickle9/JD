package by.htp.hw.unit4.task2;

import java.util.*;

public class University {

    private String name;
    private int countOfPlaces;
    private Set<Abiturient> group = new TreeSet<>(new AbiturComparator());

    public University(String name, int countOfPlaces) {
        this.name = name;
        this.countOfPlaces = countOfPlaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfPlaces() {
        return countOfPlaces;
    }

    public void setCountOfPlaces(int countOfPlaces) {
        this.countOfPlaces = countOfPlaces;
    }

    public Set<Abiturient> getGroup() {
        return group;
    }

    public void setGroup(Set<Abiturient> group) {
        this.group = group;
    }
}
