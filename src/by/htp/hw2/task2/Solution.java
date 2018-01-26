package by.htp.hw2.task2;

import java.util.Scanner;

/*Программа запрашивает у пользователя a, b, c, вычислить значение выражения a^2-(b-c)^2+ln(b^(2)+1)
* */

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = 0;
        double b = 0;
        double c = 0;
        double res;

        System.out.println("Введите переменную \"а\".");
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                a = scanner.nextDouble();
            } else {
                System.out.println("Неверное значение, введите переменную \"а\"");
                scanner.next();
                continue;
            }

            System.out.println("Введите переменную \"b\".");
            if (scanner.hasNextDouble()) {
                b = scanner.nextDouble();
            } else {
                System.out.println("Неверное значение, введите переменную \"а\"");
                scanner.next();
                continue;
            }

            System.out.println("Введите переменную \"c\".");
            if (scanner.hasNextDouble()) {
                c = scanner.nextDouble();
                break;
            } else {
                System.out.println("Неверное значение, введите переменную \"а\"");
                scanner.next();
            }
        }

        res = Math.pow(a, 2) - Math.pow((b - c), 2) + Math.log(Math.pow(b, 2) + 1);

        System.out.println("Результат" + res);

    }
}

