package io.hexlet.spring;

import io.hexlet.spring.model.Page;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController // указывает на классы с обработчиками маршрутов
public class Application {
    // Хранилище добавленных страниц, то есть обычный список
    private List<Page> pages = new ArrayList<Page>();

    // Запуск приложения
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // http localhost:8080/pages или http localhost:8080/pages?limit=1
    // Список страниц (обработчик)
    @GetMapping("/pages")    // Параметры запроса попадают в код через параметры обработчика
    public List<Page> index(@RequestParam(defaultValue = "10") Integer limit) { // параметры обработчика (в странице)
        return pages.stream().limit(limit).toList();    // У параметра можно задать значение по умолчанию
    }

    // http post localhost:8080/pages slug=someslug name=somename body=somebody
    // Создание страницы (обработчик)
    @PostMapping("/pages")
    public Page create(@RequestBody Page page) {    // автоматически передаёт данные из http-тела в код page
        pages.add(page); // Обработчик добавления страницы добавляет данные в коллекцию
        return page;     // возвращает эти же данные наружу
    }                   // Для работы этого механизма имена полей в Page должны совпадать с именами в теле запроса

    // http localhost:8080/pages/someslug
    // Вывод страницы (обработчик)
    // Получить страницу по её slug (передаётся в параметре id)
    @GetMapping("/pages/{id}")
    public Optional<Page> show(@PathVariable String id) { // извлекает параметры пути из фигурных скобок
        var page = pages.stream()
                .filter(p -> p.getSlug().equals(id))
                .findFirst();
        return page;
    }       // имя переменной должно совпадать с именем переменной в шаблоне, потому что происходит сопоставление.

    // http put localhost:8080/pages/someslug
    // Обновление страницы (обработчик)
    @PutMapping("/pages/{id}")  // обновление страницы // Параметры в обработчиках могут идти в любом порядке,
    public Page update(@PathVariable String id, @RequestBody Page data) {  //с любыми именами и допустимыми аннотациями
        var maybePage = pages.stream()              // выполняется поиск необходимой страницы в общем списке
                .filter(p -> p.getSlug().equals(id))
                .findFirst();                       // Если страница найдена, то выполняется ее обновление
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
