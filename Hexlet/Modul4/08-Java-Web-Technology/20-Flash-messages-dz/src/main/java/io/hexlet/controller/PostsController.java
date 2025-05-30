package io.hexlet.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import io.hexlet.dto.posts.PostsPage;
import io.hexlet.dto.posts.PostPage;
import io.hexlet.model.Post;
import io.hexlet.repository.PostRepository;
import io.hexlet.dto.posts.BuildPostPage;
import io.hexlet.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN (write your solution here)
    public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Name should be 2 symbols or more")
                    .check(value -> !PostRepository.existsByName(value), "Post already exists")
                    .get();
            var body = ctx.formParam("body");
            var post = new Post(name, body);
            PostRepository.save(post);
            ctx.sessionAttribute("flash", "Post was successfully created!");
            ctx.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var body = ctx.formParam("body");
            var page = new BuildPostPage(name, body, e.getErrors());
            ctx.render("posts/build.jte", model("page", page)).status(422);
        }
    }

    public static void index(Context ctx) {
        String flash = ctx.consumeSessionAttribute("flash");
        var posts = PostRepository.getEntities();
        var postPage = new PostsPage(posts, flash);
        ctx.render("posts/index.jte", model("page", postPage));
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
