package io.hexlet.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication  // выполняет автоконфигурацию приложения по установленным зависимостям
@RestController      //  отмечает классы, которые содержат обработку маршрутов
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @GetMapping("/")    // Обработчик маршрута и маршрут, переданным в нее.
    String home() {        // Сам обработчик называется home(),
        return "Hello World!"; // Обработчик возвращает строку, которая вернется как тело HTTP-ответа,
                               // что удобно в простых ситуация
    }
}
