package exercise;

import exercise.controller.GameController;
import exercise.util.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;

public final class App {

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinThymeleaf());
        });

        app.get(NamedRoutes.rootPath(), GameController::index);
        app.post(NamedRoutes.startPath(), GameController::start);
        app.post("/guess", GameController::guess);
        app.post("/guess;*", GameController::guess);
        app.post("/reset", GameController::reset);
        app.post("/reset;*", GameController::reset);

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(8080);
    }
}
