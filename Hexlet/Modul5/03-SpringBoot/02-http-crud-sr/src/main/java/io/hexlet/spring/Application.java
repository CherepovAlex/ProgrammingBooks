package io.hexlet.spring;

import io.hexlet.spring.model.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class Application {
    private List<Post> posts = new ArrayList<>();

    public static void main(String[] args) {SpringApplication.run(Application.class, args);}

    @GetMapping("/posts")   // Получения списка постов (GET /posts)
    public List<Post> index(@RequestParam(defaultValue = "10") Integer limit) {
        return posts.stream().limit(limit).toList();
    }

    @GetMapping("/posts/{id}")  // Получения одного поста по id (GET /posts/{id})
    public Optional<Post> show(@PathVariable String id) {
        Optional<Post> post = posts.stream()
                .filter(p -> p.getTitle().equals(id))
                .findFirst();
        return post;
    }

    @PostMapping("/posts")   // Создания поста (POST /posts)
    public Post create(@RequestBody Post post) {
        post.setCreatedAt(LocalDateTime.now());
        posts.add(post);
        return post;
    }

    @PutMapping("/posts/{id}")  // Обновления поста (PUT /posts/{id})
    public Post update(@PathVariable String id, @RequestBody Post data) {
        Optional<Post> maybePost = posts.stream()
                .filter(p -> p.getTitle().equals(id))
                .findFirst();

        if (maybePost.isPresent()) {
            var post = maybePost.get();
            post.setTitle(data.getTitle());
            post.setAuthor(data.getAuthor());
            post.setContent(data.getContent());
        }
        return data;
    }

    @DeleteMapping("/posts/{id}")   // Удаления поста (DELETE /posts/{id})
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getTitle().equals(id));
    }

}