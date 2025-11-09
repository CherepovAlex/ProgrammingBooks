package ru.yandex.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
// 3. Неправильный импорт - это исключение не предназначено для ручного выбрасывания.
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.yandex.dto.User;
import ru.yandex.dto.UserDto;
import ru.yandex.repository.UserRepository;
import ru.yandex.services.UserService;

import lombok.AllArgsConstructor;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController2 {
    // 2. Контроллер не должен иметь доступа к репозиторию. Вся работа с БД должна быть в сервисном слое.
    private final UserRepository userRepository;

    private final UserService userService;

    @PostMapping
    @ResponseStatus(CREATED)
    public /*User*/ UserDto  registerNew(@Valid @RequestBody UserDto dto) {
        // 1. Неправильная обработка валидации
        // - MethodArgumentNotValidException нельзя создавать так - у него нет конструктора по умолчанию
        // - Аннотация @Valid уже автоматически выполняет валидацию
        // - Дублирование логики валидации
        // Исправление: Удалить этот блок - валидация должна быть в DTO через аннотации.
//        if (dto.getFirstName() == null || dto.getEmail() == null) {
//            throw new MethodArgumentNotValidException();
//        }
        return userService.createNewUser(dto);
    }
}
