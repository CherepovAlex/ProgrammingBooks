package io.hexlet.controller;

import io.hexlet.dto.LoginPage;
import io.hexlet.dto.MainPage;
import io.hexlet.repository.UsersRepository;
import io.hexlet.util.NamedRoutes;
import io.javalin.http.Context;

import static io.hexlet.util.Security.encrypt;
import static io.javalin.rendering.template.TemplateUtil.model;

public class SessionsController {

    // BEGIN (write your solution here)
    public static void index(Context ctx) {
        var user = ctx.sessionAttribute("user");
        var page = new MainPage(user);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var error = ctx.sessionAttribute("error");
        var name = ctx.sessionAttribute("name");
        var page = new LoginPage("", "");
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        var user = UsersRepository.findByName(name).orElse(null);

        if (user != null && user.getPassword().equals(encrypt(password))) {
            ctx.sessionAttribute("user", user.getName());
            ctx.redirect("/");
        } else {
            var errorMessage = "Wrong username or password";
            var page = new LoginPage(name, errorMessage);
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("user", null);
        ctx.redirect("/");
    }
    // END
}
