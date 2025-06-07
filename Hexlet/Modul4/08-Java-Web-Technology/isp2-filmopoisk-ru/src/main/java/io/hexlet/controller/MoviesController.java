package io.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;


public class MoviesController {

    public static void index(Context ctx) throws SQLException {
        // BEGIN (write your solution here)
        var director = ctx.queryParamAsClass("director", String.class).getOrDefault(null);
        var genre = ctx.queryParamAsClass("genre", String.class).getOrDefault(null);
        var rating = ctx.queryParamAsClass("rating", Double.class).getOrDefault(null);
        var movies = io.hexlet.repository.MoviesRepository.getMovies(genre, director, rating);
        var page = new io.hexlet.dto.products.MoviesPage(movies);
        ctx.render("movies.html", model("page", page));
        // END
    }
}
