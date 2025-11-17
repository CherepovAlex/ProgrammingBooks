package io.hexlet.spring;
//ResponseEntity — это гибкий конструктор HTTP‑ответа в Spring Boot.
//С его помощью вы чётко указываете и код, и заголовки, и тело.
//Без него вы “отдаёте” только тело, и Spring сам ставит код 200 и дефолтные заголовки.
import io.hexlet.spring.model.Page;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// это builder, который собирает ответ и отправляет наружу
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class Application {

    private List<Page> pages = new ArrayList<Page>();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
        // пример GET /pages?limit=5 => HTTP/1.1 200 OK \ X-Total-Count: 42 \ тело — первые 5 страниц в JSON
    @GetMapping("/pages")
        // определяем метод контроллера, возвращающий ResponseEntity<НужныйТип>
    public ResponseEntity<List<Page>> index(@RequestParam(defaultValue = "10") Integer limit) {
        // берём первые limit страниц
        var result = pages.stream().limit(limit).toList();
        // метод, определяющий код возврата (ок-200, created-201, status(HttpStatus.SOME_CODE)-любой нужный нам код)
        // собирает всё вместе
        return ResponseEntity.ok()
                // добавляем заголовки
                .header("X-Total-Count", String.valueOf(pages.size()))
                // возврат только через body - подставляет тело ответа - список pages
                .body(result);
    }
    // пример возвращаем одну страницу или 404
    // ResponseEntity.of(optional) автоматически:
    // - вернёт 200 + тело, если Optional непустой
    // - вернёт 404, если Optional пуст
    @GetMapping("/pages/{id}")
    public ResponseEntity<Page> show(@PathVariable String id) {
        Optional<Page> page = pages.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return ResponseEntity.of(page);
    }
}
