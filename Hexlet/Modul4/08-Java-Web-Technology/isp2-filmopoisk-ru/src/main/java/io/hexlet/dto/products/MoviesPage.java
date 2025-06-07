package io.hexlet.dto.products;

import io.hexlet.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MoviesPage {
    private List<Movie> movies;
}
