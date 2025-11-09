package ru.yandex.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import ru.yandex.dto.User;
import ru.yandex.dto.UserDto;
import ru.yandex.repository.UserRepository;
import ru.yandex.services.UserService;
import ru.yandex.services.UserServiceImpl;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@AllArgsConstructor
@RestController
//@EnableWebSecurity - для использования security требуется добавить 2 аннотации
//@EnableMethodSecurity(prePostEnabled = true)
@RequestMapping("/api/users")
public class UserController3 {
    private final UserService userService;

    private final UserRepository userRepository;
//  @PreAuthorize("isCurrentUser(#id)") - добавить
    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable(name = "id") long id,
                           @AuthenticationPrincipal UserDetails authDetails) {
        userService.deleteUser(id/*, authDetails убрать*/);
    }
}
