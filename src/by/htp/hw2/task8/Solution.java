package by.htp.hw2.task8;

/* Даны три действительных числа. Возвести в квадрат те из них, значения которых неотрицательны, и в четвёртую степень - отрицательные.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        ArrayList<Double> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(readDouble());
        }

        System.out.println("Результат: ");

        for (double d: list) {

            if (d > 0) {
                System.out.println(Math.pow(d, 2));
            }
            else {
                System.out.println(Math.pow(d, 4));
            }
        }
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
