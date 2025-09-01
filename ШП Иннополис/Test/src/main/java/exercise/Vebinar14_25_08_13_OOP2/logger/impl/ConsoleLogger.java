package exercise.Vebinar14_25_08_13_OOP2.logger.impl;

import exercise.Vebinar14_25_08_13_OOP2.logger.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("ConsoleLogger: " + data);
    }
}
