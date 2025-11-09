package ru.yandex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.yandex.dto.User;
import ru.yandex.dto.UserDto;
import ru.yandex.repository.UserRepository;
import ru.yandex.services.UserService;

import jakarta.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
// Нет механизма обработки исключений, которые могут возникнуть при создании пользователя.
// Нет логирования входящих запросов и операций.
@RestController
@RequestMapping("/api/users")
public class UserController {
    // 1. Контроллер не должен напрямую работать с репозиторием.
    //  Вся работа с данными должна происходить через Service слой.
    // 2. Полевая инъекция зависимостей. Лучше использовать конструкторную инъекцию:
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    // @Autowired // это dependency injection (инъекция зависимостей) через конструктор
    // private final UserRepository userRepository;
    // private final UserService userService;
    // UserController(UserService userService, UserRepository userRepository) {
    // this.userRepository = userRepository;
    // this.userService = userService;}

    // Лучше возвращать DTO: public UserResponse registerNew ...в методе User user = userService.createUser(dto);
    // Метод возвращает User (entity), что может привести к:
    // - Утечке внутренней структуры данных
    // - Проблемам с сериализацией (циклические ссылки)
    // - Привязке API к модели данных
    @PostMapping
    @ResponseStatus(CREATED)                            // @Valid @RequestBody UserDto dto
    public /*User*/ UserDto registerNew(@Valid @RequestBody UserDto dto) { // Нет аннотации @Valid для валидации DTO.
        return userService.createNewUser(dto);
    }
}
