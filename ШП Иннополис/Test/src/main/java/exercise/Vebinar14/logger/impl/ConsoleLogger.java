package exercise.Vebinar14.logger.impl;

import exercise.Vebinar14.logger.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("ConsoleLogger: " + data);
    }
}
