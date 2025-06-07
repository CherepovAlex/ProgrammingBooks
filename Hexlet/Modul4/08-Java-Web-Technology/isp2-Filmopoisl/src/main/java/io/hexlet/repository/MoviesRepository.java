package io.hexlet.repository;

import io.hexlet.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesRepository extends io.hexlet.repository.BaseRepository {

    // BEGIN (write your solution here)
    public static List<Movie> findMovies(String director, String genre, Double minRating) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM movies WHERE 1=1");
        List<Object> parameters = new ArrayList<>();

        if (director != null && !director.isEmpty()) {
            query.append(" AND director = ?");
            parameters.add(director.trim());
        }
        if (genre != null && !genre.isEmpty()) {
            query.append(" AND genre = ?");
            parameters.add(genre.trim());
        }
        if (minRating != null) {
            query.append(" AND rating >= ?");
            parameters.add(minRating);
        }

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getString("title"),
                        resultSet.getString("director"),
                        resultSet.getString("genre"),
                        resultSet.getDouble("rating"),
                        resultSet.getInt("produced")
                );
                movie.setId(resultSet.getLong("id"));
                movies.add(movie);
            }
        }
        return movies;
    }
    // END
}
