package exercise.controller;


import exercise.dto.products.UserPage;
import exercise.dto.products.UsersPage;
import exercise.repository.UsersRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UsersController {

    // BEGIN (write your solution here)
    public static void index(Context ctx) throws SQLException {
        var users = UsersRepository.getEntities();
        var page = new UsersPage(users);
        ctx.render("users.html", model("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UsersRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        var page = new UserPage(user);
        ctx.render("user.html", model("page", page));
    }
    // END
}
