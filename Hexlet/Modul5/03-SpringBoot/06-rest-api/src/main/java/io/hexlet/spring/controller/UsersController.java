package io.hexlet.spring.controller;

import java.net.URI;

import io.hexlet.spring.Data;

import java.util.List;
import java.util.Optional;

import io.hexlet.spring.model.User;
import lombok.Setter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Setter
    private List<User> users = Data.getUsers();

    @GetMapping("/users")
    public ResponseEntity<List<User>> index(@RequestParam(defaultValue = "1") Integer userNumber,
                                            @RequestParam(defaultValue = "10") Integer limit) {
        int start = (userNumber - 1) * limit;
        int end = Math.min(start + limit, users.size());
        var newUsers = users.subList(start, end);
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(users.size()))
                .body(newUsers);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> show(@PathVariable String id) {
        return ResponseEntity.of(users.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst());
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody User user) {
        if (user.getFirstName() == null || user.getEmail() == null) {
            return ResponseEntity.unprocessableEntity().body("Validation failed: missing fields");
        }
        users.add(user);
        return ResponseEntity
                .created(URI.create("/users" + user.getId()))
                .body(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody User data) {
        Optional<User> maybeUser = users.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (maybeUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (data.getFirstName() == null || data.getEmail() == null) {
            return ResponseEntity.unprocessableEntity().body("Validation failed: missing fields");
        }
        var user = maybeUser.get();
        user.setFirstName(data.getFirstName());
        user.setEmail(data.getEmail());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable String id) {
        users.removeIf(p -> p.getId().equals(id));
    }

}