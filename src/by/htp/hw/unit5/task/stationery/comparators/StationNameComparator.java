package by.htp.hw.unit5.task.stationery.comparators;

import by.htp.hw.unit5.task.stationery.Stationery;

import java.util.Comparator;

public class StationNameComparator implements Comparator<Stationery> {

    @Override
    public int compare(Stationery o1, Stationery o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
