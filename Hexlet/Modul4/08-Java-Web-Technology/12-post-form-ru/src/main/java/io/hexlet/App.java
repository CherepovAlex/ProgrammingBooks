package io.hexlet;

import io.hexlet.dto.users.UsersPage;
import io.hexlet.model.User;
import io.hexlet.repository.UserRepository;
import io.hexlet.util.Security;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // BEGIN
        app.get("users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
            var firstName = StringUtils.capitalize(ctx.formParam("firstName"));
            var lastName = StringUtils.capitalize(ctx.formParam("lastName"));
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var encryptedPassword = Security.encrypt(password);

            var user = new User(firstName, lastName, email, encryptedPassword);
            UserRepository.save(user);
            ctx.redirect("/users");
        });
        // END
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
