class Solution {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] line;

        //Меняем 0 и 1 строчки местами
        line = arr[0];
        arr[0] = arr[1];
        arr[1] = line;

        /*for (int[] i : arr) {
            for (int y : i) {
                System.out.print(y);
            }
            System.out.println();
        }*/
    }
}