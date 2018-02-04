package by.htp.hw.unit2.task02;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {0, 1, 6, 2, 9, 0 ,0, 4};
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                list.add(i);
        }

        System.out.println(list);
    }

    @SuppressWarnings("all")
    private static double readDouble() {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Неверное значение.");
                scanner.next();
            }
        }

        return 0;
    }
}
