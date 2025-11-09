package exercise.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @interface определяет саму аннотацию
// @Retention определяет жизненный цикл аннотации - как долго аннотация должна оставаться с кодом.
// @Target - где мы будем применять аннотацию (например, в методах)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
// Параметры описываются внутри тела аннотации определенным способом. Он похож на определение методов с отсутствующим 
// телом и возможностью указать значение по умолчанию; значение по умолчанию можно и не прописывать.     
    boolean enabled();
    long threshold() default 0; // Пороговое время в миллисекундах
}
