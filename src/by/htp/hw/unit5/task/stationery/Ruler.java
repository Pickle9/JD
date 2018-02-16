package by.htp.hw.unit5.task.stationery;

public class Ruler extends Stationery implements Measurable {

    private double length;

    public Ruler(String name, double price, double length) {
        super(name, price);
        this.length = length;
    }

    @Override
    public int measure(Object object) {
        return 0;
    }
}
