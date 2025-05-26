package io.hexlet.controller;

import io.hexlet.dto.users.UserPage;
import io.hexlet.model.User;
import io.hexlet.repository.UserRepository;
import io.hexlet.util.NamedRoutes;
import io.hexlet.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import static io.javalin.rendering.template.TemplateUtil.model;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    public static void create(Context ctx) throws Exception {
        // BEGIN (write your solution here)
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var token = Security.generateToken();
        var encriptedPassword = Security.encrypt(password);
        var user = new User(firstName, lastName, email, encriptedPassword, token);
        UserRepository.save(user);
        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
        // END
    }

    public static void show(Context ctx) throws Exception {
        // BEGIN (write your solution here)
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));
        var cookieToken = ctx.cookie("token");
        if (cookieToken == null || !cookieToken.equals(user.getToken())) {
            ctx.redirect(NamedRoutes.buildUserPath());
            return;
        }
        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
        // END
    }
}
