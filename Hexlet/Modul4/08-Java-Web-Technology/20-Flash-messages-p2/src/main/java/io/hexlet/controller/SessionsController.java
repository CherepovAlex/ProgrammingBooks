package io.hexlet.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.hexlet.util.NamedRoutes;

import io.hexlet.dto.users.MainPage;
import io.hexlet.dto.users.LoginPage;
import io.hexlet.repository.UsersRepository;

import io.hexlet.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    public static void index(Context ctx) {
        var user = ctx.sessionAttribute("user");
        var page = new MainPage((String)user);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var error = ctx.sessionAttribute("error");
        var name = ctx.sessionAttribute("name");
        var page = new LoginPage(name != null ? (String) name : "", error != null ? (String) error : "");
        ctx.sessionAttribute("error", null);
        ctx.sessionAttribute("name", null);
        ctx.render("sessions/build.jte", model("page", page));

    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        if (name == null || name.isEmpty() || password == null || password.isEmpty()) {
            ctx.sessionAttribute("error", "Username or password can't be empty");
            ctx.sessionAttribute("name", name);
            ctx.redirect(NamedRoutes.buildSessionPath());
            return;
        }

        var user = UsersRepository.findByName(name);
        if (user == null || !user.get().getEncriptedPassword().equals(Security.encrypt(password))) {
            ctx.sessionAttribute("error", "Wrong username or password");
            ctx.sessionAttribute("flashType", "danger");
            ctx.redirect(NamedRoutes.buildSessionPath());
            return;
        }

        ctx.sessionAttribute("currentUser", name);
        ctx.sessionAttribute("flash", "You entered in system successfully");
        ctx.sessionAttribute("flashType", "success");
        ctx.redirect(NamedRoutes.usersPath());
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.sessionAttribute("flash", "You exited from system successfully");
        ctx.sessionAttribute("flashType", "success");
        ctx.redirect(NamedRoutes.rootPath());
    }
}
