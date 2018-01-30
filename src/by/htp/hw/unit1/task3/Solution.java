package by.htp.hw2.task3;

/* Программа вводит два число "a" и "b", если а > b, то программа вводит третье число "с" и находит сумму b + с.
  Если a = b, то программа печатает слово "Конец". Если a < b, то программа вводит третье число "с", находит сумму a + b + c,
  выводит на экран сумму a + b + c и слова "Новый год!".*/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int a;
        int b;
        int c;

        a = readInt();
        b = readInt();

        if (a > b) {
            c = readInt();
            System.out.println("\n" + b + c);
        }

        if (a == b)
            System.out.println("\nКонец");

        if (a < b) {
            c = readInt();
            System.out.println("\n" + (a + b + c) + " Новый год!");
        }
    }

    //Чтение сканнером числа(int) с консоли с "защитой от дураков".
    @SuppressWarnings("all")
    private static int readInt() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число");

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