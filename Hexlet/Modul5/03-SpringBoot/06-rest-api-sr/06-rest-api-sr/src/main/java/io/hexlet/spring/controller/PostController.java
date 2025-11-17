package io.hexlet.spring.controller;

import io.hexlet.spring.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private List<Post> posts = new ArrayList<>();

    @GetMapping   // Получения списка постов (GET /posts)
    public ResponseEntity<List<Post>> index(@RequestParam(defaultValue = "10") Integer limit) {
        List<Post> result = posts.stream().limit(limit).toList();
        return ResponseEntity.ok(result); // ok() -> 200 OK
    }

    @GetMapping("/{id}")  // Получения одного поста по id (GET /posts/{id})
    public ResponseEntity<Post> show(@PathVariable String id) {
        Optional<Post> post = posts.stream()
                .filter(p -> p.getTitle().equals(id))
                .findFirst();

        return post.map(ResponseEntity::ok) // ok() -> 200 OK
                .orElse(ResponseEntity.notFound().build()); // notFound().build() -> 404 Not Found
    }

    @PostMapping// Создания поста (POST /posts)
    public ResponseEntity<Post> create(@RequestBody Post post) {
        post.setCreatedAt(LocalDateTime.now());
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);    // status(HttpStatus.CREATED) -> 201 Created
    }

    @PutMapping("/{id}")  // Обновления поста (PUT /posts/{id})
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post data) {
        Optional<Post> maybePost = posts.stream()
                .filter(p -> p.getTitle().equals(id))
                .findFirst();

        if (maybePost.isPresent()) {
            Post post = maybePost.get();
            post.setTitle(data.getTitle());
            post.setAuthor(data.getAuthor());
            post.setContent(data.getContent());
            return ResponseEntity.ok(post); // ok() -> 200 OK
        }
        return ResponseEntity.notFound().build();   // notFound().build() -> 404 Not Found
    }

    @DeleteMapping("/{id}")   // Удаления поста (DELETE /posts/{id})
    public ResponseEntity<Void> deletePost(@PathVariable String title) {
        boolean removed = posts.removeIf(p -> p.getTitle().equals(title));
        if (removed) {
            return ResponseEntity.noContent().build();  // noContent().build() -> 204 No Content
        }
        return ResponseEntity.notFound().build();   // notFound().build() -> 404 Not Found
    }


}
