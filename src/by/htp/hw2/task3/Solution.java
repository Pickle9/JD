package by.htp.hw2.task3;

public class Solution {
    public static void main(String[] args) {
        double a = Math.random() * 10;
        double b = Math.random() * 10;
        double c = 0;
        double sum = 0;

        if (a > b) {
            c = Math.random() * 10;
            sum = b + c;
        }

        if (a == b)
            System.out.println("Конец");

        if (a < b) {
            System.out.println(a + b + c + " Новый год!");
        }
    }
}
