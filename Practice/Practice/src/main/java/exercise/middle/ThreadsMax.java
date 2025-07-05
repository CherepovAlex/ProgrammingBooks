package exercise.middle;

// Создайте многопоточное приложение для поиска максимального значения в массиве. Разделите массив на части и
// выполните поиск максимума в каждой части в отдельных потоках. Объедините результаты для получения общего максимума.


public class ThreadsMax {
    private int[] arr;
    private int maxValue;

    public ThreadsMax(int[] arr) {
        this.arr = arr;
    }

    public synchronized void updateMaxValue(int value) {
        if (value > maxValue) {
            maxValue = value;
        }
    }

    public int getMaxValue() {
        return maxValue;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1, 7, 3, 9, 2, 8, 5, 10};
        ThreadsMax finder = new ThreadsMax(arr);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arr.length / 2; i++) {
                finder.updateMaxValue(arr[i]);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = arr.length / 2; i < arr.length; i++) {
                finder.updateMaxValue(arr[i]);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Maximum value: " + finder.getMaxValue());
    }
}