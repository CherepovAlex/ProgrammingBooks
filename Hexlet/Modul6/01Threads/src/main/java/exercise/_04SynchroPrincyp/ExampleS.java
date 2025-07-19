package exercise._04SynchroPrincyp;

public class ExampleS {

    public static void main(String[] args) {

        CommonResourceS resource = new CommonResourceS();
        // создадим 2 потока, которые будут менять ресурс разделяемый ресурс
        ThreadExampleS thread1 = new ThreadExampleS(resource);
        ThreadExampleS thread2 = new ThreadExampleS(resource);
        // запускаем потоки
        thread1.start();
        thread2.start();
        // дожидаемся окончания выполнения потоков
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // проверяем результат
        System.out.println("Size: " + resource.getCounter());       // => 20000
    }

}

class CommonResourceS {

    private int counter = 0;
    // метод, у которого нужно ограничить выполнение
    // одновременно только один поток может выполнять метод increaseCounter
    public synchronized void increaseCounter() {
        // блок, которые будет выполнен только одним потоком за раз
        counter++;
    }

//    public synchronized void increaseCounter() {
//     блокировка применяется только к блоку кода внутри метода
//    synchronize(this
//    {// код, который будет выполнен только одним потоком за раз
//        counter++;
//    }

    public int getCounter() {
        return counter;
    }

}

class ThreadExampleS extends Thread {

    // разделяемый ресурс
    CommonResourceS resource;

    ThreadExampleS(CommonResourceS resource) {
        this.resource = resource;
    }
    // метод увеличивает счетчик на 1
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            resource.increaseCounter();
        }
    }

}