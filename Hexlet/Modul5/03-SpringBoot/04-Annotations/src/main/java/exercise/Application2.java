package exercise;

import exercise.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

// Определения аннотаций - это обычный код, который нужно импортировать
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController // Аннотация на уровне класса
@RequestMapping("/api") // Аннотация на уровне класса
@SpringBootApplication
public class Application2 {

    @Autowired  // Аннотация на уровне поля
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application2.class, args);
    }

    @GetMapping("/hello")   // Аннотация на уровне метода
    public String sayHello(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name) {
        // Аннотация на уровне параметров
        return "Hello, " + name + "!";
    }

    @PostMapping("/greet")  // Аннотация на уровне метода
    public String gtreet(@RequestBody String name) {    // Аннотация на уровне параметров
        return "Greetings, " + name + "!";
    }
}
