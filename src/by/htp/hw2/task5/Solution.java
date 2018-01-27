package by.htp.hw2.task5;

/*  Программа запрашивает количество чисел, затем ввожит целые числа в соответствии с указанным количеством.
    Определяет количество чётных, сумму кратных 3-м и количество чисел, модуль которых < 3.*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> listOfDigits = new ArrayList<>();
        int countOfDigits;
        int countOfEvenNumbs = 0;
        int countOfMultiple3 = 0;
        int countOfLess3 = 0;

        System.out.println("Введите количество чисел:");
        countOfDigits = readInteger();

        for (int i = 0; i < countOfDigits; i++) {
            System.out.println("Введите число:");
            listOfDigits.add(readInteger());
        }

        for (double l : listOfDigits) {

            if ((int) l % 2 == 0) {
                countOfEvenNumbs++;
            }

            if (l % 3 == 0) {
                countOfMultiple3++;
            }

            if (Math.abs(l) < 3) {
                countOfLess3++;
            }
        }

        System.out.println(String.format(
                "Кол-во чётных чисел: %o\n" +
                "Кол-во чисел, кратных 3: %o\n" +
                "Кол-во чисел, по модулю < 3: %o",
                countOfEvenNumbs, countOfMultiple3, countOfLess3));

    }

    //Чтение сканнером числа(int) с консоли с "защитой от дураков".
    @SuppressWarnings("all")
    private static int readInteger() {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Неверное значение, попробуйте ещё раз.");
                scanner.next();
            }
        }

        return 0;
    }
}
