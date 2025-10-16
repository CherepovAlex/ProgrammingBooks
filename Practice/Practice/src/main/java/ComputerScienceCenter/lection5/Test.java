package ComputerScienceCenter.lection5;

/* Конструирование исключений:
 Throwable()
 Throwable(message)   - сообщение
 Throwable(couse)     - причина
 Throwable(message, cause)
 protected Throwable(message, cause, suppression, stackTrace) */

/* Что есть у исключений:
 Сообщение (getMessage())
 Стек (getStackTrace()) - массив StackTrace-элемент
 Причина (getCause())
 Подавленные исключения (addSuppressed()/getSuppresed())  */

public class Test {
                                    // IOException - проверяемые исключения
    static class MyException extends Exception {}
                                    // непроверяемые исключения можно не проверять
    static void test() throws MyException { // из метода; бросает исключеие
        // бросай исключение
        throw new MyException();    // stacktrace заполняется в момент создания объекта исключения
    }
                                            // т.к. в методе исключение не обрабатывается try/catch,
    public static void main(String[] args) throws MyException { // то нужно выбрасывать его наружу
        test();
    }
}
