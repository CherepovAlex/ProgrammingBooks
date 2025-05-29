package io.hexlet;

import io.hexlet.controller.SessionsController;
import io.hexlet.dto.MainPage;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
           var page = new MainPage(ctx.sessionAttribute("currentUser"));
           ctx.render("index.jte", model("page", page));
        });

        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);

        app.post(NamedRoutes.sessionsPath(), SessionsController::create);

        app.delete(NamedRoutes.sessionsPath(), SessionsController::destroy);

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}