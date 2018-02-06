import java.util.ArrayList;

class Fraction {

    private int m; // Числитель
    private int n; // Знаменатель

    private Fraction(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public static void main(String[] args) {

        ArrayList<Fraction> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            list.add(new Fraction(i, i + 1));
        }

        for (Fraction f : list) {
            System.out.println(f);
        }
    }

    @Override
    public String toString() {
        return String.format("%o\n" +
                "-\n" +
                "%o\n\n", m, n);
    }
}