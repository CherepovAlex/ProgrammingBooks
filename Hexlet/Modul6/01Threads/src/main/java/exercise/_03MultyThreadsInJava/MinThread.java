package exercise._03MultyThreadsInJava;
// BEGIN (write your solution here)
import java.util.logging.Level;
import java.util.logging.Logger;

public class MinThread extends java.lang.Thread {
    private final int[] num;
    private int min;
    private final Logger logger;

    public MinThread(int[] num, Logger logger) {
        this.num = num;
        this.logger = logger;
    }

    @Override
    public void run() {
        logger.log(Level.INFO, "Thread  " + this.getName() + " started");
        min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }
        logger.log(Level.INFO, "Thread  " + this.getName() + " finished");
    }

    public int getMin() {
        return min;
    }
}
// END