package by.htp.hw.unit5.task.stationery.comparators;

import by.htp.hw.unit5.task.stationery.Stationery;

import java.util.Comparator;

public class StationCostAndNameComparator implements Comparator<Stationery> {

    @Override
    public int compare(Stationery o1, Stationery o2) {
        int o12 = o1.getName().compareTo(o2.getName());

        if (o12 == 0)
            return Double.compare(o1.getPrice(), o2.getPrice());
        else return o12;
    }
}
