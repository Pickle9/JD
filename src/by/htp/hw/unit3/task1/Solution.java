import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[][] matr = new int[10][10];
        int maxValue;

        for (int i = 0; i < matr.length; i++) {
            for (int y = 0; y < matr[i].length; y++) {
                matr[i][y] = (int)(Math.random() * 1000);
            }
        }

        maxValue = matr[0][0];

        for (int i = 0; i < matr.length; i++) {
            for (int y = 0; y < matr[i].length; y++) {
                if (maxValue < matr[i][y]) {
                    maxValue = matr[i][y];
                }
                System.out.print(matr[i][y] + " ");
            }
            System.out.println();
        }

        System.out.println(maxValue);
    }
}
