package exercise;
// Программа проходит по всем методам SomeService:
// Проверяет, есть ли у метода аннотация @LogExecutionTime.
// Если аннотация есть и enabled = true, то происходит замер времени выполнения:
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// комбинированная аннотация для запуска Spring Boot приложения
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
