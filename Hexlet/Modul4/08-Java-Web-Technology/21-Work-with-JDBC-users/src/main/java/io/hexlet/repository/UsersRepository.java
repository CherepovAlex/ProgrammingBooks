package io.hexlet.repository;

import io.hexlet.model.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepository extends BaseRepository {

    public static void save(User user) throws SQLException {
        String sql = "INSERT INTO users (name, password) VALUES (?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getEncriptedPassword());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<User> find(Long id) throws SQLException {
        var sql = "SELECT * FROM users WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var lastName = resultSet.getString("lastName");
                var user = new User(name, lastName);
                user.setId(id);
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public static List<User> getEntities() throws SQLException {
        var sql = "SELECT * FROM users";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<User>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var lastName = resultSet.getString("lastName");
                var user = new User(name, lastName);
                user.setId(id);
                result.add(user);
            }
            return result;
        }
    }

    public static Optional<User> findByName(String name) throws SQLException {
        var sql = "SELECT * FROM users WHERE name = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var id = resultSet.getLong("id");
                var lastName = resultSet.getString("lastName");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(id, name, password);
                user.setLastName(lastName);
                user.setEmail(email);
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public static boolean delete(Long id) throws SQLException {
        var sql = "DELETE FROM users WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        }
    }

}
