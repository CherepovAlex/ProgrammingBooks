package exercise.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// для доступности в рантайме
@Retention(RetentionPolicy.RUNTIME)
// для применения только к методам
@Target(ElementType.METHOD)
// Кастомная аннотация
public @interface LogExecutionTime {    // Определена с помощью @interface
    boolean enabled();  // Имеет параметры enabled (обязательный)
    long threshold() default 0; // и threshold (со значением по умолчанию)
}