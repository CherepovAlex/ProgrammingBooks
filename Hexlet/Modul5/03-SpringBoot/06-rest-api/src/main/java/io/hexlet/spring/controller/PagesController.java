package io.hexlet.spring.controller;

import io.hexlet.spring.Data;
import io.hexlet.spring.model.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PagesController {

    private List<Page> pages = new ArrayList<Page>();

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

    @PostMapping("/pages")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Page page) {
        if (page.getId() == null || page.getName() == null || page.getBody() == null) {
            return ResponseEntity.unprocessableEntity().body("Validation failed: id, name and body are required");
        }
        pages.add(page);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(page);
    }

    @PutMapping("/pages/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Page data) {
        Optional<Page> maybePage = pages.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (maybePage.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (data.getName() == null || data.getBody() == null) {
            return ResponseEntity.unprocessableEntity().body("Validation failed: name and body are required");
        }
        var page = maybePage.get();
        page.setName(data.getName());
        page.setBody(data.getBody());
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/pages/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable String id) {
        pages.removeIf(p -> p.getId().equals(id));
    }
}
