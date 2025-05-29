package io.hexlet;

import io.hexlet.util.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.hexlet.controller.CoursesController;

public class App {

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get(NamedRoutes.homePath(), CoursesController::home);
        app.get(NamedRoutes.buildCoursesPath(), CoursesController::build);

        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);

        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);
        app.get(NamedRoutes.editCoursePath("{id}"), CoursesController::edit);
        app.post(NamedRoutes.updateCoursePath("{id}"), CoursesController::update);
        app.post(NamedRoutes.deleteCoursePath("{id}"), CoursesController::destroy);

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}