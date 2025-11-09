package exercise;

import exercise.annotation.LogExecutionTime;
import exercise.service.SomeService;

import java.lang.reflect.Method;
//  берем все методы класса SomeService, находим методы с аннотацией LogExecutionTime и вызываем их методы,
//  проверяя время выполнения.
public class Application3 {
    public static void main(String[] args) {
        var service = new SomeService();

        // Итерируем все методы класса
        for(Method method : SomeService.class.getDeclaredMethods()) {
        // рефлексия — техника, которая отображает информацию о программе во время ее работы
            // Проверяем, если ли у методы аннотация @LogExecutionTime
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                var startTime = System.currentTimeMillis();

                try { // Выполяем метод с аннотацией LogExecutionTime
                    method.invoke(service);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                long endTime =System.currentTimeMillis();
                long executionTime = endTime - startTime;

                System.out.println("Executed method: " + method.getName());
                System.out.println("Execution time: " + executionTime + " milliseconds");
            }
        }
    }
}
