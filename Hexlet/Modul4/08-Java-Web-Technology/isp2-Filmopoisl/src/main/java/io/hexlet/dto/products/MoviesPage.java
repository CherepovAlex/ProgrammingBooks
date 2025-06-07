package io.hexlet.dto.products;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import io.hexlet.model.Movie;

@AllArgsConstructor
@Getter
public class MoviesPage {
    private List<Movie> movies;
}
