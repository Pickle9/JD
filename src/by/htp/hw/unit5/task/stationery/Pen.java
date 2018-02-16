package by.htp.hw.unit5.task.stationery;

import java.awt.*;

public class Pen extends Stationery implements Writable {

    private Color rodColor;

    public Pen(String name, double price) {
        super(name, price);
        this.rodColor = Color.BLUE;
    }

    public Pen(String name, double price, Color rodColor) {
        super(name, price);
        this.rodColor = rodColor;
    }

    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
