package by.htp.hw.unit5.task.stationery;

import java.awt.*;

public class Pencil extends Stationery  implements Writable {

    private Color color;

    public Pencil(String name, double price) {
        super(name, price);
        this.color = Color.GRAY;
    }

    public Pencil(String name, double price, Color color) {
        super(name, price);
        this.color = Color.GRAY;
        this.color = color;
    }

    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
