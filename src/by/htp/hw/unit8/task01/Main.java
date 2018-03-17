package by.htp.hw.unit8.task01;

public class Main {

    public static void main(String[] args) throws Exception {

        Thread thread1 = new Thread(new MyThread(1));
        Thread thread2 = new Thread(new MyThread(2));
        Thread thread3 = new Thread(new MyThread(3));
        Thread thread4 = new Thread(new MyThread(4));
        Thread thread5 = new Thread(new MyThread(5));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();


        // Вывод матрицы на экран
        System.out.println();
        int[][] matrix = Matrix.getInstance().getMatrix();
        for (int[] x : matrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
