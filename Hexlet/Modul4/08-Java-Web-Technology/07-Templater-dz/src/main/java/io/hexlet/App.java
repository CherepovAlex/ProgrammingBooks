package io.hexlet;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import io.hexlet.model.User;
import io.hexlet.dto.users.UserPage;
import io.hexlet.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN (write your solution here)
        app.get("/users", ctx ->{
            var users = Data.getUsers();
            var header = "All users";
            var page = new UsersPage(USERS, header);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var user = USERS.stream()
                    .filter(u -> u.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found"));
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
