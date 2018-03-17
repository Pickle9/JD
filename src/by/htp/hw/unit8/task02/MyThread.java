package by.htp.hw.unit8.task02;


import java.io.IOException;

public class MyThread implements Runnable {

    /* Один потом отвечает за сложение и умножение ЛИШЬ ОДНОЙ строки массива,
        т.е. сколько строк, столько и потоков. */


    // Тут сохраняются результаты вычислений.
    private int[] additionResult;
    private int[] multiplicationResult;

    private int[] matrix1Line;
    private int[] matrix2Line;

    public MyThread(int[] matrix1Line, int[] matrix2Line) throws IOException {
        if (matrix1Line.length == matrix2Line.length) {
            this.matrix1Line = matrix1Line;
            this.matrix2Line = matrix2Line;
        }
        else throw new IOException("The matrices length isn't equal.");
    }

    @Override
    public void run() {
        additionResult = additionLine();
        multiplicationResult = multiplicationLine();
    }

    private int[] additionLine() {
        int[] result = new int[matrix1Line.length];

        for (int i = 0; i < result.length; i++) {
            result[i] += matrix1Line[i] + matrix2Line[i];
        }

        return result;
    }

    private int[] multiplicationLine() {
        int[] result = new int[matrix1Line.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
            result[i] *= matrix1Line[i] * matrix2Line[i];
        }

        return result;
    }

    public int[] getAdditionResult() {
        return additionResult;
    }

    public int[] getMultiplicationResult() {
        return multiplicationResult;
    }
}
