package io.hexlet.repository;

import io.hexlet.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesRepository extends BaseRepository {

    // BEGIN (write your solution here)
    public static List<Movie> getMovies(String genre, String director, Double minRating) throws SQLException {
        List<Movie> movies = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM movies WHERE true");

        if (genre != null) {
            sql.append(" AND genre = ?");
        }
        if (director != null) {
            sql.append(" AND director = ?");
        }
        if (minRating != null) {
            sql.append(" AND rating >= ?");
        }

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql.toString())) {
            int index = 1;
            if (genre != null) {
                stmt.setString(index++, genre);
            }
            if (director != null) {
                stmt.setString(index++, director);
            }
            if (minRating != null) {
                stmt.setDouble(index++, minRating);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getString("genre"),
                        rs.getDouble("rating"),
                        rs.getInt("produced")
                );
                movie.setId(rs.getLong("id"));
                movies.add(movie);
            }
        }

        return movies;
    }
    // END
}
