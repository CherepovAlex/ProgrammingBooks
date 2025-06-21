package io.hexlet.spring;

import io.hexlet.spring.model.Page;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
// классы с обработчиками маршрутов
@RestController
public class Application {
    // Хранилище добавленных страниц, то есть обычный список
    private List<Page> pages = new ArrayList<Page>();

    // Запуск приложения
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // http localhost:8080/pages или http localhost:8080/pages?limit=1
    // Список страниц (обработчик)
    @GetMapping("/pages")
    public List<Page> index(@RequestParam(defaultValue = "10") Integer limit) { // параметры обработчика (в странице)
        return pages.stream().limit(limit).toList();
    }

    // http post localhost:8080/pages slug=someslug name=somename body=somebody
    // Создание страницы (обработчик)
    @PostMapping("/pages")
    public Page create(@RequestBody Page page) {    // передаёт данные из http-тела в код page
        pages.add(page);
        return page;
    }

    // http localhost:8080/pages/someslug
    // Вывод страницы (обработчик)
    // Получить страницу по её slug (передаётся в параметре id)
    @GetMapping("/pages/{id}")
    public Optional<Page> show(@PathVariable String id) { // извлекает параметры пути
        var page = pages.stream()
                .filter(p -> p.getSlug().equals(id))
                .findFirst();
        return page;
    }

    // http put localhost:8080/pages/someslug
    // Обновление страницы (обработчик)
    @PutMapping("/pages/{id}")
    public Page update(@PathVariable String id, @RequestBody Page data) {
        var maybePage = pages.stream()
                .filter(p -> p.getSlug().equals(id))
                .findFirst();
        if (maybePage.isPresent()) {
            var page = maybePage.get();
            page.setSlug(data.getSlug());
            page.setName(data.getName());
            page.setBody(data.getBody());
        }
        return data;
    }

    // http delete localhost:8080/pages/someslug
    // Удаление страницы (обработчик)
    @DeleteMapping("/pages/{id}")
    public void destroy(@PathVariable String id) {
        pages.removeIf(p -> p.getSlug().equals(id));
    }
}
