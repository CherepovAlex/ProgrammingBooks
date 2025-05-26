package io.hexlet;

import io.hexlet.dto.MainPage;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
           var visited = Boolean.valueOf(ctx.cookie("visited"));
           var page = new MainPage(visited);
           ctx.render("index.jte", model("page", page));
           ctx.cookie("visited", String.valueOf(true));
        });

        app.start(7070);
    }
}
