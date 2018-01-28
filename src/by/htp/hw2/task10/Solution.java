package by.htp.hw2.task10;

/*  Вычислить значение функции:
*   
*          | 9, если x <= -3.
*   F(x) = |
*          | 1 / ((x^2) + 1), если x > 3.
*   */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        double x;

        System.out.println("Введите \"x\"");
        x = readDouble();

        System.out.println("Результат:");

        if (x <= -3) {
            System.out.println(9);
        } else {
            if (x > 3) {
                System.out.println(1 / (Math.pow(x, 2) + 1));
            } else {
                System.out.println(0);
            }
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
