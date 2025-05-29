package io.hexlet;

import io.hexlet.controller.SessionsController;
import io.hexlet.dto.MainPage;
import io.hexlet.util.NamedRoutes;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            if (!isTestMode()) {
                config.bundledPlugins.enableDevLogging();
            }

            config.fileRenderer(new JavalinJte());
        });

        // BEGIN (write your solution here)
        app.get("/", ctx -> {
            System.out.println("Обработка главной страницы"); // Логирование
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.render("index.jte", model("page", page));
        });

        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.loginPath(), SessionsController::create);
        app.post(NamedRoutes.logoutPath(), SessionsController::destroy);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    private static boolean isTestMode() {
        String env = System.getenv("ENV");
        return env != null && env.equals("test");
    }
}
