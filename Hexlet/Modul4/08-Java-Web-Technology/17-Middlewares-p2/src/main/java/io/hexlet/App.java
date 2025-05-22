package io.hexlet;

import io.javalin.Javalin;

public class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.before(ctx -> {
            var path = ctx.path();
            System.out.println("Request path: " + path);
        });

        app.before(ctx -> {
            ctx.header("X-Custom-Header", "value");
        });

        app.get("/", ctx -> ctx.result("Welcome to Hexlet!"));

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}