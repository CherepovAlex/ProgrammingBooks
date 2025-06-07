package exercise.repository;

import exercise.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UsersRepository extends BaseRepository {

    // BEGIN (write your solution here)
    public static Optional<User> find(String name) throws SQLException {
        var sql = "SELECT * FROM users WHERE name = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var userName = resultSet.getString("name");
                var id = resultSet.getLong("id");
                var password = resultSet.getString("password");
                var user = new User(name, password);
                user.setId(id);
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }
    // END
}
