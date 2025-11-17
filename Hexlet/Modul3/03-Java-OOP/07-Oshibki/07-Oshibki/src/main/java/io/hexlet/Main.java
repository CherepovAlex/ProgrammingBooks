package io.hexlet;

// try -- finally

import java.io.Closeable;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            // Исполняемый код, который может сгенерировать исключение
            System.out.println("try -- body");  // выведется: try -- body
//            throw new ArithmeticException();
            throwCheckedException();
        } catch (ArithmeticException | IndexOutOfBoundsException exception) {
            // Обработка исключений ArithmeticException или IndexOutOfBoundsException
            System.out.println("try -- ArithmeticException или IndexOutOfBoundsException handler");
            // выведется: try -- ArithmeticException или IndexOutOfBoundsException handler
        } catch (CheckedException ch) {
            System.out.println("try -- CheckedException handler");
        } catch (Exception exception) {
            // Обработка исключения
            System.out.println("try -- Exception handler");
        } finally {
            // Общий код, который выполняется в любом случае
            System.out.println("try -- finally");   // выведется: try -- finally
        }

     // throwCheckedException(); // требуется обработка try-catch или throws в main

        // Create closeable object
        // body
        // Close closeable object - метод close вызывается неявно в конце catch
        try (CloseableObject object = new CloseableObject()) {
            System.out.println("body");
        } catch (IOException e) {   // блок catch не обязательный
            throw new RuntimeException();
        }

    }

    public static void throwUncheckedException() /*throws UncheckedException*/ { // не влияет
        throw new UncheckedException();
    }

    public static void throwCheckedException() throws CheckedException {    // требуется обработка
        throw new CheckedException();
    }
}

class CheckedException extends Exception {

}

class UncheckedException extends RuntimeException {

}

// переопределяем метод из интерфейса Closeable
class CloseableObject implements Closeable {
    public CloseableObject() {
        System.out.println("Create closeable object");
    }
    @Override
    public void close() throws IOException {
        System.out.println("Close closeable object");
    }
}