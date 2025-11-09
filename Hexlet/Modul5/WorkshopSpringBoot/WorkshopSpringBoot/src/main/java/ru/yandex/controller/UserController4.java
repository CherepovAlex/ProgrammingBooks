package ru.yandex.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;

import ru.yandex.dto.User;
import ru.yandex.repository.UserRepository;
import ru.yandex.services.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController4 {

    private final UserService userService;
    private final UserRepository userRepository;

    @DeleteMapping(path = "/{id}")
//    @Operation(summary = "Delete user")
    @PreAuthorize("@userRepository.findById(#id).get().getEmail() == " +
            "authentication.getName()") // Spring Expression Language
    public void delete(@PathVariable final long id) throws Exception {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        // исключение - приложение вызовет 500 ошибку

//        if ((user.getAuthorTasks() != null && user.getAuthorTasks().size() != 0) ||
//                (user.getExecutorTasks() != null & user.getExecutorTasks().size() != 0)) {
//            throw new Exception("Нельзя удалить, т.к. используется в задачах");
//        }

        userRepository.deleteById(id);
    }
}
