package io.hexlet.controller;

import io.hexlet.dto.products.MoviesPage;
import io.hexlet.repository.MoviesRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static io.javalin.rendering.template.TemplateUtil.model;

public class MoviesController {

    public static void index(Context ctx) throws SQLException {
        // BEGIN (write your solution here)
        String director = ctx.queryParam("director");
        String genre = ctx.queryParam("genre");
        Double minRating = ctx.queryParamAsClass("rating", Double.class).getOrDefault(null);

        var movies = MoviesRepository.findMovies(director, genre, minRating);
        var page = new MoviesPage(movies);

        Map<String, Object> model = new HashMap<>();
        model.put("page", page);
        model.put("director", director);
        model.put("genre", genre);
        model.put("rating", minRating);

        ctx.render("movies.html", model);
        // END
    }
}
