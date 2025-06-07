package io.hexlet.dto.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import io.hexlet.model.Movie;

@AllArgsConstructor
@Getter
public class MoviePage {
    private Movie movie;
}
