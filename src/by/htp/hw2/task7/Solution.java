package by.htp.hw2.task7;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        double a = readDouble();
        double b = readDouble();
        double c = readDouble();
        double d = readDouble();
        double res = ((a / c) * (b / d)) - ((a * b) - c) / (c * d);

        //Тут можно чекнуть переменные.
        /*System.out.println("a/c: " + a/c);
        System.out.println("b/d: " + b/d);
        System.out.println("a/c * b/d: " + (a/c)*(b/d));
        System.out.println("a*b: " + a*b);
        System.out.println("a*b - c: " + ((a*b)-c));
        System.out.println("c*d: " + c*d);
        System.out.println("((a*b)-c)/(c*d): " + ((a * b) - c) / (c * d));*/

        System.out.println("Результат: " + res);
    }

    //Чтение сканнером числа(int) с консоли с "защитой от дураков".
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
