package by.htp.hw2.task9;

/*  Составить программу для вычисления значений функции F(x) на отрезке [a,b] с шагом h.
    Результат представить в виде таблицы, первый столбец которой - значения аргумента,
    второй - соответствующее значение функции:

    F(x) = 2 * tg(x/2) + 1.

* */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        double a;
        double b;
        double h;
        double x;

        System.out.println("Введите \"а\"");
        a = readDouble();

        System.out.println("Введите \"b\"");
        b = readDouble();

        System.out.println("Введите шаг \"h\"");
        h = readDouble();

        x = a;

        System.out.println("Результат:\n" + "  Значение    Функция");

        while (x <= b) {

            System.out.println(String.format(
                        "-----------------------\n" +
                        "| %f | %f |\n" +
                        "-----------------------",
                        x, (float)(2 * Math.tan(x / 2) + 1)));

            x += h;
        }
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
