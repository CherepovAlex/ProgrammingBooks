package io.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import gg.jte.ContentType;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.hexlet.model.User;
import io.hexlet.dto.users.UsersPage;

import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var templateEngine = TemplateEngine.create(
                new DirectoryCodeResolver(Paths.get("src/main/jte")),
                ContentType.Html
        );
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte(templateEngine));
        });
        // BEGIN
        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users;
            if (term == null) {
                users = USERS;
            } else {
                users = USERS
                    .stream()
                    .filter(u -> {
                        return StringUtils.startsWithIgnoreCase(u.getFirstName(), term);
                    })
                    .toList();
            }
            var page = new UsersPage(users, term);
            ctx.render("users/index.jte", model("page", page));
        });
        // END

        app.get("/", ctx -> {ctx.render("index.jte");});

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
