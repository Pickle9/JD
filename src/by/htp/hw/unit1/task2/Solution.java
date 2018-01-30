package by.htp.hw2.task2;

import java.util.Scanner;

/* Программа запрашивает у пользователя a, b, c, вычислить значение выражения a^2-(b-c)^2+ln(b^(2)+1).*/

public class Solution {

    public static void main(String[] args) {

        double a;
        double b;
        double c;
        double res;

        System.out.println("Введите переменную \"а\".");
        a = readDouble();

        System.out.println("Введите переменную \"b\".");
        b = readDouble();

        System.out.println("Введите переменную \"b\".");
        c = readDouble();

        res = Math.pow(a, 2) - Math.pow((b - c), 2) + Math.log(Math.pow(b, 2) + 1);

        System.out.println("Результат: " + res);
    }

    //Чтение сканнером числа(int) с консоли с "защитой от дураков".
    @SuppressWarnings("all")
    private static double readDouble() {

        Scanner scanner = new Scanner(System.in);

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