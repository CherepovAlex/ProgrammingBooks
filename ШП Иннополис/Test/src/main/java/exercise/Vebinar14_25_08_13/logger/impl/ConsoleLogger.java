package exercise.Vebinar14_25_08_13.logger.impl;

import exercise.Vebinar14_25_08_13.logger.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("ConsoleLogger: " + data);
    }
}
