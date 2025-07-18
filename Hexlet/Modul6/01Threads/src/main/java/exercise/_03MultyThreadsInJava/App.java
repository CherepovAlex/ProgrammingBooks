package exercise._03MultyThreadsInJava;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN (write your solution here)
    public static HashMap<String, Integer> getMinMax(int[] numbers) {
        MinThread minThread = new MinThread(numbers, LOGGER);
        MaxThread maxThread = new MaxThread(numbers, LOGGER);

        minThread.start();
        maxThread.start();
        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException ex) {}
        var map = new HashMap<String, Integer>();
        map.put("min", minThread.getMin());
        map.put("max", maxThread.getMax());
        return map;
    }
    // END

    public static void main(String[] args) {
        int[] numbers = {10, -4, 67, 100, -100, 8};

        System.out.println(App.getMinMax(numbers)); // => {min=-100, max=100}
    }
}