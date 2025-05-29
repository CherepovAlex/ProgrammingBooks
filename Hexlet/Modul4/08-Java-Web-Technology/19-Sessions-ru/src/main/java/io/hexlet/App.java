package io.hexlet;

import io.hexlet.controller.SessionsController;
import io.hexlet.util.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            if (!isTestMode()) {
                config.bundledPlugins.enableDevLogging();
            }
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN (write your solution here)
        app.get(NamedRoutes.rootPath(), SessionsController::index);
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
      return System.getenv("ENV").equals("test");
    }
}
