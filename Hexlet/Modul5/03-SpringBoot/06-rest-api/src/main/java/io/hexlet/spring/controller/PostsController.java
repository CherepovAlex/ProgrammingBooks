package io.hexlet.spring.controller;

import io.hexlet.spring.Data;
import io.hexlet.spring.model.Post;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import lombok.Setter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostsController {

    @Setter
    private static List<Post> posts = Data.getPosts();

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> index(@RequestParam(defaultValue = "1") Integer pageNumber,
                                            @RequestParam(defaultValue = "10") Integer limit) {
        int start = (pageNumber - 1) * limit;
        int end = Math.min(start + limit, posts.size());
        var newPosts = posts.subList(start, end);

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(newPosts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> show(@PathVariable String id) {
        return ResponseEntity.of(
                posts.stream().filter(p -> p.getId().equals(id)).findFirst()
        );
    }

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Post post) {
        if (post.getId() == null || post.getTitle() == null || post.getBody() == null) {
            return ResponseEntity.unprocessableEntity().body("Validation failed: id, title and body are required");
        }
        posts.add(post);
        return ResponseEntity
                .created(URI.create("/posts" + post.getId()))
                .body(post);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Post data) {
        Optional<Post> maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (maybePost.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (data.getTitle() == null || data.getBody() == null) {
            return ResponseEntity.unprocessableEntity().body("Validation failed: title and body are required");
        }
        var post = maybePost.get();
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }

}
