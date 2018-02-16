package by.htp.hw.unit5.task.stationery.comparators;

import by.htp.hw.unit5.task.stationery.Stationery;

import java.util.Comparator;

public class StationCostComparator implements Comparator<Stationery> {

    @Override
    public int compare(Stationery o1, Stationery o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}