package exercise.service;

import exercise.annotation.LogExecutionTime;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

// Сервис с аннотирующими методами
@Service
public class SomeService {

    @LogExecutionTime(enabled = true)
    public void serve() throws InterruptedException {
        Thread.sleep(1500);
    }

    @LogExecutionTime(enabled = true, threshold = 100)
    public void anotherMethod() {
        System.out.println("Another method executed");
    }

    @PostConstruct
    public void logAnnotatedMethods() {
        // Для каждого метода проверяется наличие аннотации
        for (Method method : this.getClass().getDeclaredMethods()) {
            // Если аннотация есть ...
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                LogExecutionTime annotation = method.getAnnotation(LogExecutionTime.class);
                // и enabled=true ...
                if (annotation.enabled()) {
                    // то замеряется время выполнения
                    try {
                        long startTime = System.currentTimeMillis();
                        //использует рефлексию для вызова метода объекта service во время выполнения,
                        // даже если мы не знаем имя метода заранее.
                        method.invoke(this);
                        long executionTime = System.currentTimeMillis() - startTime;
                        // Результат выводится только если время превышает threshold
                        if (executionTime > annotation.threshold()) {
                            System.out.printf("Method %s executed in %d ms%n", method.getName(), executionTime);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}