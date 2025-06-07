package io.hexlet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class Movie {

    private Long id;

    private String title;

    private String director;

    private String genre;

    private double rating;

    private int produced;

    public Movie(String title, String director, String genre, double rating, int produced) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.rating = rating;
        this.produced = produced;
    }
}
