package exercise.controller;

import exercise.annotation.LogExecutionTime;
import exercise.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// обе для создания REST контроллера
@RestController
@RequestMapping("/api")
public class HelloController {
    // для внедрения зависимостей
    @Autowired
    private SomeService someService;

    // для обработки HTTP GET запросов
    @GetMapping("/hello")
    // для работы с параметрами запроса
    public String sayHello(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name) {
        return "Hello, " + name + "!";
    }

    // Метод с кастомной аннотацией для обработки HTTP GET запросов
    @GetMapping("/slow")
    // При вызове этого метода будет замеряться время его выполнения
    @LogExecutionTime(enabled = true, threshold = 100)
    public String slowMethod() throws InterruptedException {
        Thread.sleep(500);
        return "Slow response afer 500ms";
    }

    @GetMapping("/service-call")
    public String callService() throws InterruptedException {
        someService.serve();
        someService.anotherMethod();
        return "SomeService methods called!";
    }

}
