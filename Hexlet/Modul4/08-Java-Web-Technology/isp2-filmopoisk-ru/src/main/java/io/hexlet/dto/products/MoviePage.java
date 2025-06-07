package io.hexlet.dto.products;

import io.hexlet.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MoviePage {
    private Movie movie;
}
