package ru.yandex.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import ru.yandex.repository.TaskRepository;
import ru.yandex.services.TaskService;

import ru.yandex.dto.Task;
import ru.yandex.dto.TaskDto;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
// 2. Неправильный путь в @RequestMapping: Лучше сделать более специфичным: @RequestMapping("/api/tasks")
@RequestMapping(path = "/api")
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskService taskService;
    // 3. Избыточная конфигурация @PostMapping, produces избыточно, JSON по умолчанию
    @PostMapping(
            path = "/tasks",
            produces = "application/json"
    )
    @ResponseStatus(CREATED)
    public /*Task*/ TaskDto createTask(
            @Valid @RequestBody TaskDto dto,
            // это никоуровненый код: так делать не надо
            // spring позволяет сразу получить залогиненного пользователя
            // @Authentication authentication
            // и далее authentication.getCurrentUserName();
            @RequestHeader(name = HttpHeaders.AUTHORIZATION) String token)
    {

        Long authorId = taskService.findAuthorId(token);
        return taskService.createTask(dto, authorId);
    }
}
