package by.htp.hw2.task1;

/* Напишите программу нахождения гипотенузы и площади прямоугольного треугольника по двум катетам.*/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        double a;
        double b;
        double hyp;
        double square;

        System.out.println("Введите катет \"а\":");
        a = readDouble();

        System.out.println("Введите катет \"b\":");
        b = readDouble();

        hyp = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));   //Расчёт гипотенузы.
        square = (a * b) / 2;   //Расчёт площади

        System.out.println(String.format("Гипотенуза треугольника с катетами %o и %o = %f", (int) a, (int) b, hyp));
        System.out.println("А площадь данного треугольника = " + square);
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