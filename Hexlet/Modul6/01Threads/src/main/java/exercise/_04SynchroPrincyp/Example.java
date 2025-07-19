package exercise._04SynchroPrincyp;

public class Example {

    public static void main(String[] args) {

        CommonResource resource = new CommonResource();
        // создадим 2 потока, которые будут менять ресурс разделяемый ресурс
        ThreadExample thread1 = new ThreadExample(resource);
        ThreadExample thread2 = new ThreadExample(resource);
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
        System.out.println("Size: " + resource.getCounter());   // => < 20000
    }

}

class CommonResource {

    private int counter = 0;

    public void increaseCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

}

class ThreadExample extends Thread {

    // разделяемый ресурс
    CommonResource resource;

    ThreadExample(CommonResource resource) {
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