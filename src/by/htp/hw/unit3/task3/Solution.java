class Solution {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        long sum = 0;   //сумма
        long mult = 1;  //произведение

        for (int[] i : arr) {
            for (int y : i) {
                sum += y;
                mult *= y;
            }
        }

        System.out.println(sum + " " + mult);
    }
}