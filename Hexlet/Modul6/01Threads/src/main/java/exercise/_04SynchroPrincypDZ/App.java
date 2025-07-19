package exercise._04SynchroPrincypDZ;

import java.util.Arrays;

class App {

    public static void main(String[] args) {
        // BEGIN (write your solution here)
        SafetyList list = new SafetyList();

        Thread thread1 = new Thread(new ListThread(list));
        Thread thread2 = new Thread(new ListThread(list));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.getSize());
        // END
    }
}


// BEGIN (write your solution here)
class ListThread extends Thread {

    private SafetyList safetyList;

    public ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {e.printStackTrace();}
            safetyList.add(i);
        }
    }
}
// END

class SafetyList {
    // BEGIN (write your solution here)
    private int[] array = new int[10];
    private int size = 0;

    public synchronized void add(int element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = element;
        size++;
    }

    public int get(int index) {
        return array[index];
    }

    public int getSize() {
        return size;
    }
// END
}


