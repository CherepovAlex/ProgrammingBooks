package ru.yandex.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.dto.Task;
import ru.yandex.dto.TaskDto;
import ru.yandex.dto.User;
import ru.yandex.dto.UserDto;
import ru.yandex.repository.TaskRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final AuthService authService; // для работы с токенами

    public Long findAuthorId(String token) {
        // Декодирование JWT токена или проверка в БД
        return authService.validateTokenAndGetUserId(token);
    }

    public TaskDto createTask(TaskDto dto, Long authorId) {
        // Валидация бизнес-логики
        if (dto.getDeadline() != null && dto.getDeadline().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Deadline cannot be in the past");
        }

        // Создание задачи
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.getCompleted() != null ? dto.getCompleted() : false);
        task.setDeadline(dto.getDeadline());
        task.setAuthorId(authorId);

//        Task savedTask = TaskRepository.save(task);

        return convertToDto(task);
    }

    private TaskDto convertToDto(Task task) {
        // преобразование entity в DTO
        return new TaskDto(); // не возвращаем пароль
    }
}