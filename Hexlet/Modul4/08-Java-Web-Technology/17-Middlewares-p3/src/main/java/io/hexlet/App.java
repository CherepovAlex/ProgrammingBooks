package io.hexlet;

import io.javalin.Javalin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {

    public static Javalin getApp() {

        var app = Javalin.create();

        // Миддлвара для логирования даты и времени запроса
        app.before(ctx -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(formatter);
            System.out.println("[" + timestamp + " ] Request received: " + ctx.method() + " " + ctx.path());
        });

        app.before(ctx -> {
           String id = ctx.queryParam("id");
           if (id == null || id.isEmpty()) {
               ctx.status(400).result("Bed request: Missing 'id' parameter");
               ctx.skipRemainingHandlers(); // Завершаем обработку
           }
        }); http://localhost:7070/resource

        // Эта мидлвара и обработчики не будут выполнены, если параметр "id" отсутствует
        app.before(ctx -> {
           var path = ctx.path();
            System.out.println("Request path: " + path);
        });

        app.get("/resource", ctx -> {
           String id = ctx.queryParam("id");
           ctx.result("Resource with id: " + id);
        }); // http://localhost:7070/resource?id=2

        // Другие обработчики

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}