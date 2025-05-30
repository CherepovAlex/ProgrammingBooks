package io.hexlet;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

            int startIndex = (page - 1) * per;
            int endIndex = Math.min(startIndex + per, USERS.size());

            if (startIndex >= USERS.size() || startIndex < 0) {
                ctx.json(List.of());
                return;
            }

            List<Map<String, String>> map = USERS.subList(startIndex, endIndex);
            ctx.json(map);
        });
        // END
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}