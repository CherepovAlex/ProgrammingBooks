package io.hexlet;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        app.before(ctx -> {
            var path = ctx.path();
            System.out.println("Request path: " + path);
        });

        app.get("/", ctx -> {
            ctx.result("Hello from middleware!");
        });

        app.after(ctx -> {
            System.out.println("Response has been sent");
        });

        app.start(7070);
    }
}