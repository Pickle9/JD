package by.htp.hw.unit2.task03;

public class Solution {

    public static void main(String[] args) {

        int[] arr = {1, 2, 1};
        boolean b1 = true;
        boolean b2 = true;

        //проверка на возрастание
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                b1 = false;
                break;
            }
        }

        //проверка на убывание
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                b2 = false;
                break;
            }
        }

        if (b1) {
            System.out.println("возрастающий");
        } else {
            if (b2) {
                System.out.println("убывающий");
            } else {
                System.out.println("ни такой, ни такой");
            }
        }
    }
}
