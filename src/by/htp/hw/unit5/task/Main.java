package by.htp.hw.unit5.task;

import by.htp.hw.unit5.task.stationery.Pen;
import by.htp.hw.unit5.task.stationery.Pencil;
import by.htp.hw.unit5.task.stationery.Ruler;
import by.htp.hw.unit5.task.stationery.Stationery;
import by.htp.hw.unit5.task.stationery.comparators.StationCostAndNameComparator;
import by.htp.hw.unit5.task.stationery.comparators.StationCostComparator;
import by.htp.hw.unit5.task.stationery.comparators.StationNameComparator;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Stationery> set1 = new TreeSet<>(new StationCostComparator());
        set1.add(new Pen("z", 10));
        set1.add(new Pen("b", 5));
        set1.add(new Pencil("c", 20));
        set1.add(new Ruler("a", 1, 20));
        System.out.println(set1.toString());

        Set<Stationery> set2 = new TreeSet<>(new StationNameComparator());
        set2.add(new Pen("z", 10));
        set2.add(new Pen("l", 5));
        set2.add(new Pencil("p", 20));
        set2.add(new Ruler("a", 1, 20));
        System.out.println(set2);

        Set<Stationery> set3 = new TreeSet<>(new StationCostAndNameComparator());
        set3.add(new Pen("z", 10));
        set3.add(new Pen("a", 5));
        set3.add(new Pencil("c", 20));
        set3.add(new Ruler("a", 1, 20));
        System.out.println(set3);
    }
}
