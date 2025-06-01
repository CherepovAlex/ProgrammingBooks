package io.hexlet.controller;

import io.hexlet.dto.users.BuildUserPage;
import io.hexlet.dto.users.UserPage;
import io.hexlet.dto.users.UsersPage;
import io.hexlet.repository.UsersRepository;
import io.hexlet.util.NamedRoutes;
import io.hexlet.util.Security;
import io.hexlet.model.User;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;


public class UsersController {
    // Отображение списка пользователей
    public static void index(Context ctx) throws SQLException {
        String flash = ctx.consumeSessionAttribute("flash");
        String flashType = ctx.consumeSessionAttribute("flashType");
        String currentUser = ctx.sessionAttribute("currentUser");
        var users = UsersRepository.getEntities();
        var page = new UsersPage(users, flash, currentUser);
        page.setFlashType(flashType);
        ctx.render("users/index.jte", model("page", page));
    }

    // Форма создания нового пользователя
    public static void build(Context ctx) throws SQLException {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", model("page", page));
    }

    // Создание пользователя (обработка формы)
    public static void create(Context ctx) throws SQLException {
        var name = ctx.formParam("name");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var passwordConfirmation = ctx.formParam("passwordConfirmation");

        // Валидация
        if (name == null || name.isEmpty()) {
            ctx.sessionAttribute("flash", "Name can't be empty");
            ctx.sessionAttribute("flashType", "danger");
            ctx.redirect(NamedRoutes.buildUserPath());
            return;
        }

        if (!password.equals(passwordConfirmation)) {
            ctx.sessionAttribute("flash", "Passwords doesn't match");
            ctx.sessionAttribute("flashType", "danger");
            ctx.redirect(NamedRoutes.buildUserPath());
            return;
        }

        var token = Security.generateToken();
        var encriptedPassword = Security.encrypt(password);
        var user = new User(name, lastName, email, encriptedPassword, token);
        UsersRepository.save(user);

        ctx.sessionAttribute("flash", "User has been created successfully!");
        ctx.sessionAttribute("flashType", "success");
        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));

    }

    // Просмотр конкретного пользователя
    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UsersRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        var cookieToken = ctx.cookie("token");

        if (cookieToken == null || !cookieToken.equals(user.getToken())) {
            ctx.sessionAttribute("flash", "You have't rights for view");
            ctx.sessionAttribute("flashType", "danger");
            ctx.redirect(NamedRoutes.buildUserPath());
            return;
        }
        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    public static void delete(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        if (!UsersRepository.delete(id)) {
            throw new NotFoundResponse("User not found");
        }

        ctx.sessionAttribute("flash", "User has been deleted successfully!");
        ctx.sessionAttribute("flashType", "success");
        ctx.redirect(NamedRoutes.usersPath());
    }

}
