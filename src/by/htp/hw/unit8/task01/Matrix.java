package by.htp.hw.unit8.task01;

public class Matrix {

    private volatile int[][] matrix;
    private static Matrix instance = new Matrix();

    private Matrix() {
        matrix = new int[5][5];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public static Matrix getInstance() {
        return instance;
    }
}

