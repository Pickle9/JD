package by.htp.hw.unit8.task01;

public class MyThread implements Runnable {

    private int id;

    public MyThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            Matrix matrix = Matrix.getInstance();

            synchronized (Matrix.getInstance()) {
                if (matrix.getMatrix()[x][x] == 0) {
                    matrix.getMatrix()[x][x] = id;
                    System.out.println(String.format("id: %o - [%o][%o]", id, x, x));
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
