package by.htp.hw.unit5.task.stationery;

public abstract class Stationery {
    private String name;
    private double price;

    public Stationery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "name=" + name + ", price=" + price;
    }
}
