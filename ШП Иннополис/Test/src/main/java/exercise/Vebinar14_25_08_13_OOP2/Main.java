package exercise.Vebinar14_25_08_13_OOP2;

import exercise.Vebinar14_25_08_13_OOP2.logger.impl.ConsoleLogger;
import exercise.Vebinar14_25_08_13_OOP2.logger.Logger;
import exercise.Vebinar14_25_08_13_OOP2.logger.impl.files.CsvFileLogger;
import exercise.Vebinar14_25_08_13_OOP2.logger.impl.files.TxtFileLogger;

public class Main {
    public static void main(String[] args) {
        Logger myConcoleLogger = new ConsoleLogger();
        myConcoleLogger.log("Hello from log!");

        Logger myTxtLogger = new TxtFileLogger();
        myTxtLogger.log("Hello from txt logger");

        Logger myCsvLogger = new CsvFileLogger("super_csv_log");
        myCsvLogger.log("Hello, from, CSV, Logger");
    }
}
