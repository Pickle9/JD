package by.htp.hw2.task6;

/*  Программа вводит количество чисел N, а затем N вещественных чисел.
    Программа усекает вещественные числа и определяет, сколько среди усечённых чисел чётных и > 15.*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> listOfDigits = new ArrayList<>();
        int countOfDigits;
        int countOfEvenNumbs = 0;
        int countOfMoreThan15 = 0;

        System.out.println("Введите количество чисел:");
        countOfDigits = readInteger();

        for (int i = 0; i < countOfDigits; i++) {
            System.out.println("Введите число:");
            listOfDigits.add(readInteger());
        }

        for (double l : listOfDigits) {

            if (l % 2 == 0) {
                countOfEvenNumbs++;
            }

            if (l > 15) {
                countOfMoreThan15++;
            }
        }

        System.out.println(String.format(
                        "Кол-во чётных чисел: %o\n" +
                        "Кол-во чисел > 15: %o",
                countOfEvenNumbs, countOfMoreThan15));

    }

    //Чтение сканнером числа(int) с консоли с "защитой от дураков".
    @SuppressWarnings("all")
    private static int readInteger() {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                return (int) scanner.nextDouble();
            } else {
                System.out.println("Неверное значение, попробуйте ещё раз.");
                scanner.next();
            }
        }

        return 0;
    }
}
