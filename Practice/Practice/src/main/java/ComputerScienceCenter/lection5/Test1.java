package ComputerScienceCenter.lection5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Test1 {

    static class MyException extends Exception {
//      public MyException(String message) {
//            super(message); // не информативный конструктор
//        }
        public MyException(String message, Throwable couse) {
            super(message, couse); // информативный конструктор
        }
    }
    // прмер работы с выбросом исключения
    static void test() throws MyException {
        throw new MyException("", null);
    }

    public static void main(String[] args) throws MyException {
        // обработка исключения
        try {
            test();
        } catch (MyException ex) {
            ex.printStackTrace();   // печатает сообщение исключения, его класс, его причину и его цепочку,
            // также подавленные; ничем не отличается от стандартного; учебное назначение
        }
        new Test1().readFile();
    }

    void readFile() throws MyException {
        try {               // читаем файл в массив байтов
            byte[] bytes = Files.readAllBytes(Paths.get("/etc/passwd"));
            System.out.println(Arrays.toString(bytes)); // переводим байты в строку
        } catch (IOException e) {
//            throw new MyException("Unable to read file");   // не понятно какой файл читали
            throw new MyException("Unable to read file", e);   // указана причина не чтения файла
        }
    }
    // будет в консоли StackTrace
    // Test$MyException: Unable to read file
    //  at Test.readFile(Test.java:36
    //  at Test.main(Test.java:31
    // Caused by: java.nio.file.NoSuchFileException: \etc\passwd
    // ...
}
