package by.htp.hw2.task4;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        double a;
        double b;
        double c;

        a = readDouble();
        b = readDouble();

        if (a == b) {
            System.out.println("Скоро Новый Год!");
        }
        else {
            c = readDouble();

            System.out.println(a + b + c);
            System.out.println(Math.pow(a, 2) + Math.pow(b, 2));
            System.out.println("Моя любимая футбольная команда.");
        }
    }

    @SuppressWarnings("all")
    private static double readDouble() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Неверное значение, попробуйте ещё раз.");
                scanner.next();
            }
        }

        return 0;
    }
}
