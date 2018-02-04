package by.htp.hw.unit2.task01;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        double mass[] = new double[100];
        double k = readDouble();
        double sum = 0;

        for (int i = 0; i < 100; i++) {
            mass[i] = i;
        }

        for (double d : mass) {
            if (d % k == 0) {
                sum += d;
                //System.out.println(d);
            }
        }

        System.out.println(sum);
    }

    @SuppressWarnings("all")
    private static double readDouble() {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Неверное значение.");
                scanner.next();
            }
        }

        return  0;
    }
}
