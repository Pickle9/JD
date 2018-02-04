package by.htp.hw.unit2.task04;

public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[100];
        int count = 0;

        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        for (int i : arr) {
            if (i % 2 == 0 && i != 0) {
                System.out.println(i);
                count++;
            }
        }

        if (count == 0)
            System.out.println("чётных нет");
    }
}
