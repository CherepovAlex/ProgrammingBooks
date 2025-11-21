package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Аннотация, объединяющая @Configuration, @EnableAutoConfiguration, @ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // Запуск Spring Boot приложения
    }
}
