package exercise.controller.users;
// src/main/java/io/hexlet/controller/users/PostsController.java
//Реализуйте дополнительные обработчики маршрутов для Post:
//
//GET /api/users/{id}/posts — список всех постов, написанных пользователем с таким же userId, как id в маршруте
//POST /api/users/{id}/posts – создание нового поста, привязанного к пользователю по id. Код должен возвращать
// статус 201, тело запроса должно содержать slug, title и body. Обратите внимание, что userId берется из маршрута

import java.util.List;
import java.util.stream.Collectors;

import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController         // Помечаем класс как REST контроллер (возвращает данные в формате JSON)
@RequestMapping("/api") // Устанавливаем базовый путь для всех методов контроллера - /api
public class PostsController {

    @Setter // // Статический список постов, инициализированный тестовыми данными
    private static List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")                // Обработка GET запросов по пути /api/users/{id}/posts
    public List<Post> index(@PathVariable int id) { // Метод возвращает список постов, принимает id пользователя из URL
        return posts.stream()                       // Преобразуем список в поток для обработки
                .filter(post -> post.getUserId() == id) // Фильтруем посты, оставляя только те, где userId совпадает с переданным id
                .collect(Collectors.toList());      // Собираем отфильтрованные посты обратно в список
    }

    @PostMapping("/users/{id}/posts")               // Обработка POST запросов по пути /api/users/{id}/posts
    @ResponseStatus(HttpStatus.CREATED)             // Устанавливаем HTTP статус 201 (Created) при успешном выполнении
    public Post create(@PathVariable int id, @RequestBody Post postData) {
        Post newPost = new Post(); // Метод создает новый пост, принимает id из URL и данные поста из тела запроса
        newPost.setUserId(id);                  // Устанавливаем userId из параметра пути
        newPost.setSlug(postData.getSlug());    // Копируем slug из полученных данных
        newPost.setTitle(postData.getTitle());  // Копируем title из полученных данных
        newPost.setBody(postData.getBody());    // Копируем body из полученных данных

        posts.add(newPost);                     // Добавляем новый пост в общий список
        return newPost;                         // Возвращаем созданный пост
    }

}
// END
