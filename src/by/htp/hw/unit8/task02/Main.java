package by.htp.hw.unit8.task02;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        // Наша исходная матрица.
        int[][] matrix = {{1, 2, 3, 4, 5},
                         {6, 7, 8, 9, 10},
                         {11, 12, 13, 14, 15},
                         {16, 17, 18, 19, 20},
                         {21, 22, 23, 24, 25}};

        // Объекты класса моего потока, которые необходимы для доступа к результатам вычислений.
        MyThread myThread1 = new MyThread(matrix[0], matrix[0]);
        MyThread myThread2 = new MyThread(matrix[1], matrix[1]);
        MyThread myThread3 = new MyThread(matrix[2], matrix[2]);
        MyThread myThread4 = new MyThread(matrix[3], matrix[3]);
        MyThread myThread5 = new MyThread(matrix[4], matrix[4]);

        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        Thread thread3 = new Thread(myThread3);
        Thread thread4 = new Thread(myThread4);
        Thread thread5 = new Thread(myThread5);

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

        // Сбор результатов работы потоков
        int[][] additionResult = {myThread1.getAdditionResult(),
                myThread2.getAdditionResult(),
                myThread3.getAdditionResult(),
                myThread4.getAdditionResult(),
                myThread5.getAdditionResult()};

        int[][] multiplyResult = {myThread1.getMultiplicationResult(),
                myThread2.getMultiplicationResult(),
                myThread3.getMultiplicationResult(),
                myThread4.getMultiplicationResult(),
                myThread5.getMultiplicationResult()};

        // Ну и смотрим на результаты
        System.out.println("Addition result:");
        for (int[] i : additionResult) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println("\nMultiplication result:");
        for (int[] i : multiplyResult) {
            System.out.println(Arrays.toString(i));
        }
    }
}
