package io.hexlet.spring;

import io.hexlet.spring.model.Page;
import io.hexlet.spring.model.User;
import net.datafaker.Faker;
import io.hexlet.spring.model.Post;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Data {
    private static final int ITEMS_COUNT = 30;

    public static List<Post> getPosts() {
        Faker faker = new Faker();

        List<Integer> ids = IntStream
                .range(1, ITEMS_COUNT + 1)
                .boxed()
                .toList();

        List<Post> posts = new ArrayList<>();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            var id = "post" + ids.get(i);
            var title = faker.gameOfThrones().house();
            var body = faker.gameOfThrones().quote();
            var post = new Post(id, title, body);
            posts.add(post);
        }

        return posts;
    }

    public static List<User> getUsers() {
        Faker faker = new Faker();
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= ITEMS_COUNT; i++) {
            users.add(new User("user" + i, faker.name().firstName(), faker.internet().emailAddress()));
        }
        return users;
    }

    public static List<Page> getPages() {
        Faker faker = new Faker();
        List<Page> pages = new ArrayList<>();
        for (int i = 1; i <= ITEMS_COUNT; i++) {
            var page = new Page();
            page.setId("page" + i);
            page.setName(faker.lorem().word());
            page.setBody(faker.lorem().paragraph());
            pages.add(page);
        }
        return pages;
    }

}
