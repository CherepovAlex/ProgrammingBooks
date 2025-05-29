package io.hexlet.controller;

import io.javalin.http.Context;
import io.hexlet.NamedRoutes;

public class SessionsController {

    public static void build(Context ctx) {
        ctx.render("sessions/build.jte");
    }

    public static void create(Context ctx) {
        var nickname = ctx.formParam("nickname");
        var password = ctx.formParam("password");
        if (nickname == null || nickname.isEmpty() || password == null || password.isEmpty()) {
            ctx.status(400);
            ctx.redirect(NamedRoutes.buildSessionPath());
            return;
        }
        ctx.sessionAttribute("currentUser", nickname);
        ctx.redirect("/");
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }

}
