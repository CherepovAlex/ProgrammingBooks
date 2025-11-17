package io.hexlet.spring.controller;

import io.hexlet.spring.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(defaultValue = "10") Integer limit) {
        List<User> result = users.stream().limit(limit).toList();
        return ResponseEntity.ok(result);
    } // 200

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        boolean emailNotBlank = user.getEmail().isBlank();
        if (emailNotBlank) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User email is blank");
        }
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    } // 201

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean removed = users.removeIf(i -> i.getId().equals(id));
        if (removed) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.notFound().build(); // 404
    } //204

}
